package com.shopstudy.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BoardDto {

    private Long boardId;
    private String title;
    private String content;
    private String email;
    private String name;
    private String delType;
    private Date createAt;
    private Date updateAt;

}
