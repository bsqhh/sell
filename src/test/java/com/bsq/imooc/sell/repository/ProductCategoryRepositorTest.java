package com.bsq.imooc.sell.repository;

import com.bsq.imooc.sell.dao.ProductCategoryRepositor;
import com.bsq.imooc.sell.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositorTest {

    @Autowired
    private ProductCategoryRepositor repositor;

   @Test
    public void findOneTest()
    {
        ProductCategory productCategory=repositor.findById(1).get();
        System.out.println(productCategory.toString());
    }


    @Test
    public void  findByCategoryTypeInTest()
    {
        List<Integer> list=Arrays.asList(2,3,4);
        List<ProductCategory> result=repositor.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}