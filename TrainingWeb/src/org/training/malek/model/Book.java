package org.training.malek.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6539148293623536648L;

	@Id
	@GeneratedValue
	private int id;

	private String bookName;
	private Date date;
	private String test;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", date=" + date
				+ ", test=" + test + "]";
	}

	
}
