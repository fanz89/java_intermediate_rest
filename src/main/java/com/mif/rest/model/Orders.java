package com.mif.rest.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Size(max = 30)
    private String purchaseOrderNumber;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date shipDate;

    private int freightCharge;

    private int taxes;

    private char paymentReceived;

    @Size(max = 150)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customers;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employees employees;

    @ManyToOne
    @JoinColumn(name = "shipping_method_id")
    private ShippingMethods shippingMethods;

    @OneToMany(mappedBy = "orders")
    private List<OrderDetails> orderDetails = new ArrayList<>();

}
