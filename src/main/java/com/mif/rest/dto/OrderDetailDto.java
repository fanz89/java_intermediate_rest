package com.mif.rest.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDto {

    private String productName;
    private int quantity;
    private String unitPrice;
    private String discount;
    private String extendedPrice;

}
