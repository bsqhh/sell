package com.bsq.imooc.sell.service.impl;

import com.bsq.imooc.sell.entity.ProductCategory;
import com.bsq.imooc.sell.dao.ProductCategoryRepositor;
import com.bsq.imooc.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepositor repositor;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repositor.findById(categoryId).get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return repositor.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repositor.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repositor.save(productCategory);
    }
}
