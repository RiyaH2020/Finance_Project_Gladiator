package com.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.entity.Product;
import com.casestudy.service.ProductsListService;

@RestController
@CrossOrigin
public class IndexController {

	@Autowired
	private ProductsListService productsListService;
	
	@GetMapping("/index")
	public Product featureProduct() {
		Product product = productsListService.fetchSampleProduct();
		return product;
	}
}
