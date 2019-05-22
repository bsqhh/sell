package com.bsq.imooc.sell.service;

import com.bsq.imooc.sell.entity.SellerInfo;

//卖家端
public interface SellerService {

    //通过通过openid查询卖家端信息
    SellerInfo findSellerInfoByOpenid(String openid);
}
