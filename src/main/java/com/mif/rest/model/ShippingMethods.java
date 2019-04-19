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
@Table(name = "Shipping_Methods")
public class ShippingMethods {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shippingMethodId;

    @Size(min = 3, max = 20)
    private String shippingMethod;

    @JsonIgnore
    @OneToMany(mappedBy = "shippingMethods")
    private List<Orders> orders = new ArrayList<>();

}
