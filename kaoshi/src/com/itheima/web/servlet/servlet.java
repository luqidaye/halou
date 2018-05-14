package com.itheima.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Books;

import com.itheima.service.BookServiceImpl;



public class servlet extends BaseServlet {
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			BookServiceImpl service = new BookServiceImpl();
			service.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void findNewPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			BookServiceImpl service = new BookServiceImpl();
			List<Books> books = service.findNewPro();
//3.调用service查询热门商品信息
			
//4.请求转发到商城首页(/jsp/index.jsp)
			request.setAttribute("books", books);
			
			request.getRequestDispatcher("/product_list.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
