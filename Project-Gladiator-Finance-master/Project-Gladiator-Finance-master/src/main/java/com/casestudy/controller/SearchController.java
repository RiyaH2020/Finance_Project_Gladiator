package com.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.dto.ProductQualifier;
import com.casestudy.entity.Product;
import com.casestudy.service.SearchService;

@RestController
@CrossOrigin
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@PostMapping("/search")
	public List<Product> fetchRelated(@RequestBody ProductQualifier qualify){
		List<Product> qualifyingList=searchService.fetchRelated(qualify.getQualifier());
		return qualifyingList; 
	}

}
