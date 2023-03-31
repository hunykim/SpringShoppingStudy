package com.shopstudy.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class OrderDto {

    private String userId;
    private long productId;
    private String productName;
    private int productPrice;
    private int orderCnt;
    private String status;
    private Date orderDt;
    private Date updateAt;

}
