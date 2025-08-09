package com.casestudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casestudy.dto.ProductEmiStatus;
import com.casestudy.entity.Installment;
import com.casestudy.entity.Product;
import com.casestudy.repository.ProductsListRepository;

@Service
@Transactional
public class ProductsListServiceImpl implements ProductsListService{

	@Autowired
	ProductsListRepository productsListRepository;
	
	public List<Product> fetchAllProducts() {
		return productsListRepository.fetchAll();
	}

	public Product fetchProductById(int id) {
		return productsListRepository.fetch(Product.class, id);
	}

	public Product fetchSampleProduct() {
		return fetchProductById(productsListRepository.fetchSampleProduct());
	}
	
	public ProductEmiStatus fetchProductAndEmiStatus(int id, int cardNum) {
		boolean isPending = false;
		ProductEmiStatus productEmiStatus = new ProductEmiStatus();
		List<Integer> orderIds= productsListRepository.fetchOrderIdByProductIdAndCardNumber(id, cardNum);
		Product product = productsListRepository.fetch(Product.class, id);

		if(orderIds.size()!=0) {
			int orderId = (int)orderIds.get(0);
			List<Installment> installments = productsListRepository.fetchInstallmentsByOrderId(orderId);
			
			for(Installment installment: installments) {
				if(installment.getStatus().equalsIgnoreCase("Not paid")) {
					isPending=true;
					break;
				}
			}
		}

		productEmiStatus.setProduct(product);
		productEmiStatus.setEmiPending(isPending);
		return productEmiStatus;
	}

}
