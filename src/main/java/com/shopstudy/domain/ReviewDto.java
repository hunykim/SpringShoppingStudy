package com.shopstudy.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class ReviewDto {

    private long id;
    private String userId;
    private String nickname;
    private long productId;
    private String content;
    private int reviewStar;
    private String photo;
    private String delType;
    private Date createAt;
    private Date updateAt;

}
