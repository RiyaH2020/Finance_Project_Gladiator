package com.casestudy.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;


@Component("user")
public class GenericRepository {

	@PersistenceContext
	protected EntityManager entityManager;

	@Transactional
	public Object save(Object obj) {
		
		Object updatedObj = entityManager.merge(obj);
		return updatedObj;
		
	}
	
	public <F> F fetch(Class<F> clazz, Object pk) {
		 
		F fetchedData = entityManager.find(clazz,pk);
		return fetchedData;
	}
}
