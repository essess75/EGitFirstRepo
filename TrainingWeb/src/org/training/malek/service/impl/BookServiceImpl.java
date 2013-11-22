package org.training.malek.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.malek.dao.impl.BookDAO;
import org.training.malek.model.Book;
import org.training.malek.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDAO;

	@Override
	public Book find(int id) {
		return bookDAO.find(id);
	}

	@Override
	public Book create(Book book) {
		return bookDAO.create(book);
	}

	@Override
	public void delete(int id) {
		bookDAO.delete(find(id));
	}

	@Override
	public void delete(Book book) {
		bookDAO.delete(book);
	}

	@Override
	public void update(Book book) {
		bookDAO.update(book);
	}

	@Override
	public List<Book> findAll() {
		return bookDAO.findAll();
	}

}
