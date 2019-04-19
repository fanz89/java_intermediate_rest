package com.mif.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Products")
public class Products {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Size(min = 3, max = 50)
    private String productName;

    private double unitPrice;

    private char inStock;

    @JsonIgnore
    @OneToMany(mappedBy = "products")
    private List<OrderDetails> orderDetails = new ArrayList<>();

}
