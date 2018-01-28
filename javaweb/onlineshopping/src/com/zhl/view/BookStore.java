package com.zhl.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookStore extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String userid=(String) request.getSession().getAttribute("userid");
		if(userid==null){
			request.setAttribute("Error", "���¼���ٲ���");
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		}
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("Head First Java<a href='/onlineshopping/ShoppingCartClServlet?bookname="+"java"+"'>���빺�ﳵ</a><br/>");
		out.println("Html&CSS<a href='/onlineshopping/ShoppingCartClServlet?bookname="+"html"+"'>���빺�ﳵ</a><br/>");
		out.println("Jquery<a href='/onlineshopping/ShoppingCartClServlet?bookname="+"jquery"+"'>���빺�ﳵ</a><br/>");
		out.println("Javascript<a href='/onlineshopping/ShoppingCartClServlet?bookname="+"javascript"+"'>���빺�ﳵ</a><br/>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}