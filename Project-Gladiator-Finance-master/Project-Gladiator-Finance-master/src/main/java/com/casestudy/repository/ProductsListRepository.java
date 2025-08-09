package com.casestudy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.casestudy.entity.Installment;
import com.casestudy.entity.Product;

@Repository
public class ProductsListRepository extends GenericRepository{

	@PersistenceContext
	protected EntityManager entityManager;
	
	public List<Product> fetchAll(){
		String jpql = "select p from Product as p";
		Query q = entityManager.createQuery(jpql);
		List<Product> products = q.getResultList();
		return products;
	}
	
	public int fetchSampleProduct() {
		String jpql = "select o.product.productId from Order as o group by o.product.productId order by count(o.product.productId) desc";
		Query q = entityManager.createQuery(jpql);
		List i=q.getResultList();
		return (Integer)i.get(0);
		}
	
	public List<Integer> fetchOrderIdByProductIdAndCardNumber(int productId, int cardNumber) {
		String jpql = "select o.orderId from Order o where o.product.productId=:pid and o.card.cardNumber=:cnum order by o.placedDate desc";
		Query q = entityManager.createQuery(jpql);
		q.setParameter("pid", productId);
		q.setParameter("cnum", new Long(cardNumber));
		List<Integer> orderIds=q.getResultList();
		return orderIds;
	}
	
	public List<Installment> fetchInstallmentsByOrderId(int orderId){
		String jpql = "select i from Installment as i where i.order.orderId=:oid";		
		Query q = entityManager.createQuery(jpql);
		q.setParameter("oid", orderId);
		List<Installment> installments = q.getResultList();
		return installments;
	}
}
