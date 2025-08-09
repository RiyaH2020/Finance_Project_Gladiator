package com.casestudy.service;

import java.util.List;

import com.casestudy.entity.Product;

public interface SearchService {

	public List<Product> fetchRelated(String qualifier);
}
