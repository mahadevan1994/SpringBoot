package com.sampleapp.hateoasdemo.controller;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sampleapp.hateoasdemo.dao.ProductDAO;
import com.sampleapp.hateoasdemo.model.HateoasEnabledProductListVO;
import com.sampleapp.hateoasdemo.model.HateoasEnabledProductVO;
import com.sampleapp.hateoasdemo.model.ProductListVO;
import com.sampleapp.hateoasdemo.model.ProductVO;

@RestController
public class ProductRESTController {
     
    @RequestMapping(value = "/products")
    public ProductListVO getAllProducts()
    {
        ProductListVO productsList  = new ProductListVO();
 
        for (ProductVO product : ProductDAO.getProductList()) 
        {
            productsList.getProducts().add(product);
        }
 
        return productsList;
    }
    
    @RequestMapping(value = "/HATEOAS/products")
    public HateoasEnabledProductListVO getAllProductsHATEOAS()
    {
    	HateoasEnabledProductListVO productsList  = new HateoasEnabledProductListVO();
 
        for (HateoasEnabledProductVO product : ProductDAO.getHateoasEnabledProductList()) 
        {	
        	if (!product.hasLinks()){
	        	ResponseEntity<HateoasEnabledProductVO> getProductById = ControllerLinkBuilder
	                    .methodOn(ProductRESTController.class).getProductByIdHATEOAS(product.getProductId());
	        	Link link = ControllerLinkBuilder
	                    .linkTo(getProductById)
	                    .withSelfRel();
	        	product.add(link);
	        	if (product.getStockStatus().equals("inStock")){
		        	ResponseEntity<ProductVO> addToCart = ControllerLinkBuilder
		                    .methodOn(ProductRESTController.class).addToCart(product.getProductId());
		            Link addToCartLink = ControllerLinkBuilder
		                    .linkTo(addToCart)
		                    .withRel("addToCart");
		        	product.add(addToCartLink);
	        	}
        	}
            productsList.getHateoasEnabledProducts().add(product);
        }
        Link selfLink = ControllerLinkBuilder
                .linkTo(ControllerLinkBuilder
                .methodOn(ProductRESTController.class).getAllProductsHATEOAS())
                .withSelfRel();
        productsList.add(selfLink);
 
        return productsList;
    }
      
    @RequestMapping(value = "/product/{id}")
    public ResponseEntity<ProductVO> getProductById (@PathVariable("id") int id)
    {
        if (id <= 10) {
            ProductVO product = ProductDAO.getProductList().get(id-1);
            return new ResponseEntity<ProductVO>(product, HttpStatus.OK);
        }
        return new ResponseEntity<ProductVO>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/HATEOAS/product/{id}")
    public ResponseEntity<HateoasEnabledProductVO> getProductByIdHATEOAS (@PathVariable("id") int id)
    {
        if (id <= 10) {
        	HateoasEnabledProductVO product = ProductDAO.getHateoasEnabledProductList().get(id-1);
        	if (!product.hasLinks()){
		    	ResponseEntity<HateoasEnabledProductVO> getProductById = ControllerLinkBuilder
		                .methodOn(ProductRESTController.class).getProductByIdHATEOAS(product.getProductId());
		    	Link link = ControllerLinkBuilder
		                .linkTo(getProductById)
		                .withSelfRel();
		    	product.add(link);
		    	if (product.getStockStatus().equals("inStock")){
		        	ResponseEntity<ProductVO> addToCart = ControllerLinkBuilder
		                    .methodOn(ProductRESTController.class).addToCart(product.getProductId());
		            Link addToCartLink = ControllerLinkBuilder
		                    .linkTo(addToCart)
		                    .withRel("addToCart");
		        	product.add(addToCartLink);
	        	}
        	}
            return new ResponseEntity<HateoasEnabledProductVO>(product, HttpStatus.OK);
        }
        return new ResponseEntity<HateoasEnabledProductVO>(HttpStatus.NOT_FOUND);
    }
     
    @RequestMapping(value = "/products/{id}/addToCart")
    public ResponseEntity<ProductVO> addToCart (@PathVariable("id") int id)
    {
        //add product to cart
        return null;
    }
}