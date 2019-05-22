package com.bsq.imooc.sell.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

//存放回话机制
@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;

}
