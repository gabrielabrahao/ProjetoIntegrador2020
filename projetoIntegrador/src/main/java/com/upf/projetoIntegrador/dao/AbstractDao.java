package com.upf.projetoIntegrador.dao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public abstract class AbstractDao<T, PK extends Serializable> {

	@SuppressWarnings("unchecked")
	protected
	final Class<T> entityClass = 
			(Class<T>) ( (ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	
	@PersistenceContext
	protected EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void save(T entity) { 

		entityManager.persist(entity);
	}
	
	public void update(T entity) {
		
		entityManager.merge(entity);
	}
	
	public void delete(PK id) {
		
		entityManager.remove(entityManager.getReference(entityClass, id));
	}
	
	public T findByID(PK id) {
		
		return entityManager.find(entityClass, id);
	}
	
public T findByText(String text) {
		
		return entityManager.find(entityClass, text);
	}
	
	
	
	public List<T> findAll() {
		
		return entityManager
				.createQuery("from " + entityClass.getSimpleName(), entityClass)
				.getResultList();
		
		
	}
	
public List<T> findAllOrderIdAsc() {
		
		return entityManager
				.createQuery("from " + entityClass.getSimpleName()+" order by id asc", entityClass)
				.getResultList();
		
		
	}

	/*
	 * public List<T> findIdFK(String column) {
	 * 
	 * return entityManager .createQuery("from " + entityClass.getSimpleName(),
	 * entityClass) .getResultList();
	 * 
	 * 
	 * }
	 */


	
	protected List<T> createQuery(String jpql, Object... params) {
		TypedQuery<T> query = entityManager.createQuery(jpql, entityClass);
		for (int i = 0; i < params.length; i++) {
		    query.setParameter(i+1, params[i]);
        }
    	return query.getResultList();
	}
}
