package com.zhl.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhl.model.Book;

public class ShoppingCartView extends HttpServlet {

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
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		HttpSession session=request.getSession();
		HashMap<String,Book> booklist=(HashMap<String, Book>) session.getAttribute("booklist");
		if(booklist!=null){
			for(Map.Entry<String, Book> entry: booklist.entrySet()){
				
				Book book=entry.getValue();
				out.println("书名："+book.getBookname()+"\t数量"+book.getNumber()+"<br/>");
			}
//			Iterator iterator=(Iterator) booklist.keySet();
//			while(iterator.hasNext()){
//				String key=(String) iterator.next();
//				Book book=booklist.get(key);
//				out.println("书名："+book.getBookname()+"\t数量"+book.getNumber()+"<br/>");
//			}
		}else{
			out.println("您的购物车是空的<br/>");
		}
		out.println("<a href='/onlineshopping/BookStore'>返回图书商城</a>");
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
