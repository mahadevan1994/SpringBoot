package com.sampleapp.hateoasdemo.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.github.javafaker.Faker;
import com.sampleapp.hateoasdemo.model.HateoasEnabledProductVO;
import com.sampleapp.hateoasdemo.model.ProductVO;

public class ProductDAO {
	static List<ProductVO> list = new ArrayList<>();
	static List<HateoasEnabledProductVO> hateoasEnabledList = new ArrayList<>();
    static Faker faker = new Faker();
    static ProductVO product;
    static HateoasEnabledProductVO hateoasEnabledProduct;
    public static void setProductList() 
    { 
    	List<Integer> oosList = Arrays.asList(2,5,9);
    	String stockStatus;
        for (int i = 1; i <= 10; i++){ 
        if (oosList.contains(i)){
        	stockStatus = "outOfStock";
        }
        else{
        	stockStatus = "inStock";
        }
        String productName = faker.ancient().hero();
        String description = faker.lorem().sentence();
        product = new ProductVO(i, productName, description, stockStatus);
        hateoasEnabledProduct = new HateoasEnabledProductVO(i, productName, description, stockStatus);
        list.add(product);
        hateoasEnabledList.add(hateoasEnabledProduct);
        }
    }
    public static List<ProductVO> getProductList() 
    {
        return list;
    }
    public static List<HateoasEnabledProductVO> getHateoasEnabledProductList() 
    {
        return hateoasEnabledList;
    }
}