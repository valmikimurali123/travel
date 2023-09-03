package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Student_dao;

import dto.Student_dto;


@WebServlet("/save")
public class Signup extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

        Student_dto dto=new Student_dto();
	
	dto.setEmail(req.getParameter("email"));
	dto.setName(req.getParameter("name"));
	dto.setPassword(req.getParameter("pwd"));
	dto.setMobile(Long.parseLong(req.getParameter("mob")));
	
	Student_dao dao=new Student_dao();
	dao.save(dto);
	//resp.getWriter().print("<h1>done<h1>");
	req.getRequestDispatcher("LoginPage.html").include(req, resp);
	
	}
	

}
