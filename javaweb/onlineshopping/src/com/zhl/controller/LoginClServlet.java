package com.zhl.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhl.model.*;
import com.zhl.util.Encryption;

public class LoginClServlet extends HttpServlet {

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
		
		
		User user=new User();
		String userid=request.getParameter("userid");
		if(userid==null){
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		}
		String password=Encryption.getEncrypedPWD(request.getParameter("password"));
		UserService userService=new UserService();
		System.out.println(userid+"==== "+password);
		user.setUserid(userid);
		user.setPassword(password);
		
		if(userService.checkUser(user)){
			HttpSession session=request.getSession();
			session.setAttribute("userid", user.getUserid());
			Cookie cookie=new Cookie("JSESSIONID", session.getId());
			cookie.setMaxAge(60*30);
			response.addCookie(cookie);
			
			request.getRequestDispatcher("/BookStore").forward(request, response);
		}else{
			request.getRequestDispatcher("/Error").forward(request, response);
		}
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
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
