package com.example.demo2.controller;


import com.example.demo2.services.Product;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    static Map<String, Product> products = Collections.synchronizedMap(new HashMap<String, Product>());


    @ApiOperation(value = "获取商品列表", notes = "获取商品列表的函数")
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public List<Product> getProductList() {
        List<Product> r = new ArrayList<Product>(products.values());
        return r;
    }

    @ApiOperation(value = "上架商品", notes = "根据Product创建商品")
    @ApiImplicitParam(name = "product", value = "商品实体product", required = true, dataType = "Product")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postProduct(@RequestBody Product product) {
        products.put(product.getP_name(), product);
        return "success";
    }
}
