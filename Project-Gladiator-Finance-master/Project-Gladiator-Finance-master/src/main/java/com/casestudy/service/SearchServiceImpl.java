package com.casestudy.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.entity.Product;
import com.casestudy.repository.ProductsListRepository;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private ProductsListRepository productRepo;
	
	
	public List<Product> fetchRelated(String qualifier) {
		List<Product>list=productRepo.fetchAll();
		List<Product> qualifyingList=new ArrayList<Product>();
		
		for(Product p:list) {
			if(p.getName().toLowerCase().contains(qualifier.toLowerCase())||p.getProductDetails().toLowerCase().contains(qualifier.toLowerCase())||p.getType().toLowerCase().contains(qualifier.toLowerCase()))
				qualifyingList.add(p);
		}
		
		return qualifyingList;
	}

}
