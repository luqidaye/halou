package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.Books;
import com.itheima.util.C3P0Util;

public class BookDaoImpl {
QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	public List<Books> findAll() throws SQLException {
		String sql="select*from books";
		return qr.query(sql, new BeanListHandler<>(Books.class));
	}
	public void delete(String id) throws SQLException {
		String sql="delete from books where id=?";
		qr.update(sql,id);
		
	}
	

}
