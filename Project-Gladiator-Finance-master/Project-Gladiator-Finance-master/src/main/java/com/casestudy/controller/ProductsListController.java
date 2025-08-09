package com.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.dto.ProductEmiStatus;
import com.casestudy.entity.Product;
import com.casestudy.service.ProductsListService;

@RestController
@CrossOrigin
public class ProductsListController {

	@Autowired
	private ProductsListService productListService;
	
	@GetMapping("/products-list")
	public List<Product> productList(){
		return productListService.fetchAllProducts();
	}
	
	@GetMapping("/get-product")
	public ProductEmiStatus getProduct(@RequestParam("productId") int productId,@RequestParam("cardNum") String cardNum) {
		return productListService.fetchProductAndEmiStatus(productId, Integer.parseInt(cardNum));
	}
	
	@GetMapping("/product-info")
	public Product getProductInfo(@RequestParam("productId") int productId) {
		return productListService.fetchProductById(productId);
	}
}
