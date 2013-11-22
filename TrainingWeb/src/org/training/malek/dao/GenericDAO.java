/**
 * 
 */
package org.training.malek.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author smart
 * 
 */
@Repository
@Transactional(readOnly = true)
public abstract class GenericDAO<T> implements GenericDAOInterface<T> {
	@PersistenceContext(unitName = "trainingPU")
	private EntityManager entityManager;

	private Class<T> clazz;

	@Override
	@Transactional(readOnly = false)
	public T create(T entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(T entity) {
		entityManager.remove(entity);
	}

	@Override
	public List<T> findAll() {
		Query query = entityManager.createQuery("from " + clazz.getName()
				+ " as o");
		return (List<T>) query.getResultList();
	}

	@Override
	@Transactional(readOnly = false)
	public void update(T entity) {
		entityManager.merge(entity);
	}

	@Override
	public T find(Object id) {
		return entityManager.find(clazz, id);
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

}
