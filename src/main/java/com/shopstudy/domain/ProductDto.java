package com.shopstudy.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductDto {

    private long productId;
    private String productName;
    private int productPrice;
    private String productType;
    private int discount;
    private int shippingCost;
    private String photo;

}
