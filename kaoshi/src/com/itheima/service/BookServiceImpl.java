package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.BookDaoImpl;
import com.itheima.domain.Books;

public class BookServiceImpl {

	public List<Books> findNewPro() throws SQLException {
		BookDaoImpl dao=new BookDaoImpl();
		return dao.findAll();
	}

	public void delete(String id) throws SQLException {
		BookDaoImpl dao=new BookDaoImpl();
		dao.delete(id);
		
	}
	
	
}
