package org.training.malek.service;

import java.util.List;

import org.training.malek.model.Book;

public interface BookService {
	public Book find(int id);

	public Book create(Book book);

	public void delete(int id);

	public void delete(Book book);

	public void update(Book book);

	public List<Book> findAll();
}
