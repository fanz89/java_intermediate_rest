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
@Table(name = "Customers")
public class Customers {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    @Size(min = 3, max = 50)
    private String companyName;

    @Size(min = 3, max = 30)
    private String firstname;

    @Size(min = 3, max = 50)
    private String lastname;

    @Size(min = 3, max = 255)
    private String billingAddress;

    @Size(min = 3, max = 50)
    private String city;

    @Size(min = 3, max = 20)
    private String stateOfProvince;

    @Size(min = 3, max = 20)
    private String zipCode;

    @Size(min = 3, max = 75)
    private String email;

    @Size(min = 3, max = 200)
    private String companyWebsite;

    @Size(min = 10, max = 30)
    private String phoneNumber;

    @Size(min = 3, max = 30)
    private String faxNumber;

    @Size(min = 3, max = 255)
    private String shipAddress;

    @Size(min = 3, max = 50)
    private String shipCity;

    @Size(min = 3, max = 50)
    private String shipStateOrProvince;

    @Size(min = 3, max = 20)
    private String shipZipCode;

    @Size(min = 3, max = 30)
    private String shipPhoneNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "customers")
    private List<Orders> orders = new ArrayList<>();

}
