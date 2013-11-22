package org.training.malek.dao;

import java.util.List;

public interface GenericDAOInterface<T> {
	public T create(T entity);
	public void delete(T entity);
	public List<T> findAll();
	public void update(T entity);
	public T find(Object id);
}
