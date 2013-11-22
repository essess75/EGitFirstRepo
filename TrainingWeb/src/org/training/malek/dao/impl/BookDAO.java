package org.training.malek.dao.impl;

import org.springframework.stereotype.Repository;
import org.training.malek.dao.GenericDAO;
import org.training.malek.model.Book;

@Repository
public class BookDAO extends GenericDAO<Book> {

	public BookDAO() {
		setClazz(Book.class);
	}
}
