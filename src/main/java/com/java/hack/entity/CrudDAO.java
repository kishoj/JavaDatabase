package com.java.hack.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class CrudDAO<T, K extends Serializable> {

	protected Class<T> clazz;
	protected EntityManager entityManager;
	
	public CrudDAO(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public List<T> getAll(Class<T> clazz) {
		return getAll(clazz, null, null);
	}
	
	public List<T> getAll(Class<T> clazz, Integer page, Integer size) {
		entityManager.getTransaction().begin();
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(clazz);
		Root<T> rootResults = criteria.from(clazz);
		criteria.select(rootResults);
		List<T> executionResults = null;
		if (size != null && page != null && page.intValue() > 0) {
			executionResults = entityManager.createQuery(criteria).setFirstResult((page - 1) * size).setMaxResults(size)
					.getResultList();
		} else {
			executionResults = entityManager.createQuery(criteria).getResultList();
		}

		entityManager.getTransaction().commit();
		return executionResults;
	}

	public T findOne(K arg0) {
		return entityManager.find(clazz, arg0);
	}

	public <S extends T> S save(S object) {
		entityManager.getTransaction().begin();
		
		entityManager.persist(object);
		entityManager.flush();
		entityManager.refresh(object);
		
		entityManager.getTransaction().commit();
		return object;
	}

	protected T update(T object) {
		entityManager.getTransaction().begin();
		
		entityManager.merge(object);
		entityManager.flush();
		
		entityManager.getTransaction().commit();
		return object;
	}

	public void delete(T object) {
		entityManager.getTransaction().begin();
		
		if (entityManager.contains(object)) {
			entityManager.remove(object);
		}
		
		entityManager.getTransaction().commit();
	}

	public Iterable<T> findAll() {
		entityManager.getTransaction().begin();
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(clazz);
		Root<T> rootResults = criteria.from(clazz);
		criteria.select(rootResults);
		List<T> executionResults = null;
		executionResults = entityManager.createQuery(criteria).getResultList();
		
		entityManager.getTransaction().commit();
		return executionResults;
	}
	
	public long count() {
		entityManager.getTransaction().begin();
		
		CriteriaBuilder qb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = qb.createQuery(Long.class);
		cq.select(qb.count(cq.from(clazz)));
		
		entityManager.getTransaction().commit();
		return entityManager.createQuery(cq).getSingleResult();
	}
}
