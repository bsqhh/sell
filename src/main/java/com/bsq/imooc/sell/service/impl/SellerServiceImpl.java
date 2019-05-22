package com.bsq.imooc.sell.service.impl;

import com.bsq.imooc.sell.dao.SellerInfoRepository;
import com.bsq.imooc.sell.entity.SellerInfo;
import com.bsq.imooc.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl  implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
