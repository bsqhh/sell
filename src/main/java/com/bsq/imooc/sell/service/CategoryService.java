package com.bsq.imooc.sell.service;

import com.bsq.imooc.sell.entity.ProductCategory;

import java.util.List;

public interface CategoryService {

    //查询一条记录
    ProductCategory  findOne(Integer categoryId);

    //查询所有
    List<ProductCategory> findAll();

    //查询所有买家段
    List<ProductCategory>  findByCategoryTypeIn(List<Integer> categoryTypeList);

    //增加修改
    ProductCategory save(ProductCategory productCategory);
}
