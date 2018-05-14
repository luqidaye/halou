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
			//1.��ȡ�����ʶ
			String methodName = request.getParameter("method");
			//2.��ȡ��ǰִ������ֽ������
			      Class clazz = this.getClass();
			//3.��ȡָ���������ֽ������
			      Method method=clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			//4.��ִ�з���ִ��
			      method.invoke(this, request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			def(request,response);
		}
	}

	private void def(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("msg", "�����ʵķ���������,�����ʵ���ٷ���");
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

