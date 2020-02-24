package com.sampleapp.hateoasdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sampleapp.hateoasdemo.dao.ProductDAO;

@SpringBootApplication
public class HateoasdemoApplication {

	public static void main(String[] args) {
		ProductDAO.setProductList();
		SpringApplication.run(HateoasdemoApplication.class, args);
	}

}
