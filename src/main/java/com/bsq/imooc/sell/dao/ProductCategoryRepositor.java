package com.bsq.imooc.sell.dao;

import com.bsq.imooc.sell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepositor extends JpaRepository<ProductCategory,Integer> {
        //买家端的查询所有订单记录
        List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
