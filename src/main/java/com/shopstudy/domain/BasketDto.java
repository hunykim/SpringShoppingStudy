package com.shopstudy.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BasketDto {

    private long id;
    private String userId;
    private long productId;
    private String productName;
    private int productPrice;
    private int shippingCost;

}
