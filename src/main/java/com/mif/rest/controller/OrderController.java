package com.mif.rest.controller;

import com.mif.rest.dto.OrderDetailDto;
import com.mif.rest.dto.OrderDto;
import com.mif.rest.model.OrderDetails;
import com.mif.rest.model.Orders;
import com.mif.rest.repository.OrderRepository;
import com.mif.rest.service.CurrencyService;
import com.mif.rest.service.PercentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private PercentService percentService;

    @GetMapping("")
    public Page<OrderDto> index(Pageable pageable) {

        Page<Orders> page = orderRepository.findAll(pageable);
        int totalElements = (int) page.getTotalElements();

        return new PageImpl<>(page.stream()
                .map(order -> {

                            double subTotal = 0;
                            for (OrderDetails od : order.getOrderDetails()) {
                                double discount = ((od.getQuantity() * od.getUnitPrice()) * od.getDiscount()) / 100;
                                subTotal += (od.getQuantity() * od.getUnitPrice()) - discount;
                            }

                            List<OrderDetailDto> orderDetails = new ArrayList<>();
                            order.getOrderDetails().forEach(o -> {
                                orderDetails.add(OrderDetailDto.builder()
                                        .productName(o.getProducts().getProductName())
                                        .quantity(o.getQuantity())
                                        .unitPrice(currencyService.currencyUS(o.getUnitPrice()))
                                        .discount(percentService.convertPercent(o.getDiscount()))
                                        .extendedPrice(currencyService.currencyUS(o.getQuantity() * o.getUnitPrice()))
                                        .build());
                            });

                            return OrderDto.builder()
                                    .orderId(order.getOrderId())
                                    .orderDate((order.getOrderDate() != null) ? new SimpleDateFormat("dd/MM/yyy").format(order.getOrderDate()) : null)
                                    .purchaseOrderNumber(order.getPurchaseOrderNumber())
                                    .customer(order.getCustomers().getLastname() + ", " + order.getCustomers().getFirstname())
                                    .employee(order.getEmployees().getLastname() + ", " + order.getEmployees().getFirstname())
                                    .shipDate((order.getShipDate() != null) ? new SimpleDateFormat("dd/MM/yyy").format(order.getShipDate()) : null)
                                    .orderSubTotal(currencyService.currencyUS(subTotal))
                                    .taxes(currencyService.currencyUS(order.getTaxes()))
                                    .shippingHandling(currencyService.currencyUS(order.getFreightCharge()))
                                    .orderTotal(currencyService.currencyUS(subTotal + order.getTaxes() + order.getFreightCharge()))
                                    .orderDetailsDto(orderDetails)
                                    .build();
                        }
                )
                .collect(Collectors.toList()), pageable, totalElements
        );
    }

}
