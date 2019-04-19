package com.mif.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Order_Details")
public class OrderDetails {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderDetailId;

    private int quantity;

    private double unitPrice;

    private int discount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products products;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

}
