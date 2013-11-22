package org.training.malek.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.training.malek.model.Book;
import org.training.malek.service.BookService;
import org.training.malek.service.impl.BookServiceImpl;

/**
 * The Class TestController.
 */
@Controller
public class TestController implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2364210759641076951L;

	@Autowired
	private BookService bookService;

	/**
	 * Affiche.
	 * 
	 * @return the string
	 */
	@RequestMapping(value = "/test.do")
	public @ResponseBody
	String affiche() {		
		for (int i = 0; i < 10000; i++) {
			Book book = new Book();
			book.setBookName(String.valueOf(i));
			book.setDate(new Date());
			book.setTest(String.valueOf(i*i));
			bookService.create(book);
		}
		return "coool";
	}	
}
