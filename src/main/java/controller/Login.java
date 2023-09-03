package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.Student_dao;

import dto.Student_dto;

@WebServlet("/login")
public class Login extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ep=req.getParameter("ep");
		String password=req.getParameter("pwd");
		
		Student_dao dao=new Student_dao();
		
		try
		{
			long mob=Long.parseLong(ep);
			resp.getWriter().print("<h1>this is mobile number</h1>");
			
			Student_dto dto=dao.login(mob);
			if(dto==null)
			{
				resp.getWriter().print("<h1> Invalid Mobile Number</h1>");
				req.getRequestDispatcher("LoginPage.html").include(req, resp);
			}
			else
			{
				if(dto.getPassword().equals(password))
				{
					resp.getWriter().print("<h1>login success</h1>");
					//req.setAttribute("list", dao.fetchAll());
					req.getRequestDispatcher("book.html").include(req, resp);
				}
				else
				{
					resp.getWriter().print("<h1>Invalid password</h1>");
					req.getRequestDispatcher("LoginPage.html").include(req, resp);
				}
			}
			
			
		}
		catch (Exception e) {
		
			String em=ep;
			//resp.getWriter().print("<h1>This is email<h1>");
		
		Student_dto dto=dao.login1(em);
		if(dto==null)
		{
			resp.getWriter().print("<h1> Invalid email</h1>");
			req.getRequestDispatcher("LoginPage.html").include(req, resp);
		}
		else
		{
			if(dto.getPassword().equals(password))
			{
				resp.getWriter().print("<h1>login success</h1>");
				//req.setAttribute("list", dao.fetchAll());
				req.getRequestDispatcher("book.html").include(req, resp);
			}
			else
			{
				resp.getWriter().print("<h1>Invalid password</h1>");
				req.getRequestDispatcher("LoginPage.html").include(req, resp);
			}
		}
		}
		
	}

}
