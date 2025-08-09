package com.casestudy.service;

import java.util.List;

import com.casestudy.dto.ProductEmiStatus;
import com.casestudy.entity.Product;

public interface ProductsListService {
	List<Product> fetchAllProducts();
	Product fetchProductById(int id);
	Product fetchSampleProduct();
	ProductEmiStatus fetchProductAndEmiStatus(int id, int cardNum); 
}
