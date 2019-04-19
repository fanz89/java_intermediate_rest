package com.mif.rest.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long orderId;
    private String orderDate;
    private String purchaseOrderNumber;
    private String customer;
    private String employee;
    private String shippingMethod;
    private String shipDate;
    private String orderSubTotal;
    private String taxes;
    private String shippingHandling;
    private String orderTotal;

    private List<OrderDetailDto> orderDetailsDto;

}
