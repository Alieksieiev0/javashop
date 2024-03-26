package com.github.javashop.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class BaseDto {
    private UUID id;
    private Date createdAt;
    private Date updateAt;
}
