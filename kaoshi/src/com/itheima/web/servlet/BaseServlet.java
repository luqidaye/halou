package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//1.获取请求标识
			String methodName = request.getParameter("method");
			//2.获取当前执行类的字节码对象
			      Class clazz = this.getClass();
			//3.获取指定方法的字节码对象
			      Method method=clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			//4.让执行方法执行
			      method.invoke(this, request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			def(request,response);
		}
	}

	private void def(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("msg", "您访问的方法不存在,请求核实后再访问");
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

