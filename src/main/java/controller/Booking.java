package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Student_dao;
import dto.Booking_dto;
@WebServlet("/booking")
public class Booking extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Booking_dto dto=new Booking_dto();

		dto.setName(req.getParameter("name"));
		dto.setOrigin(req.getParameter("origin"));
		dto.setDestination(req.getParameter("destination"));
		
		
		Student_dao dao=new Student_dao();
		dao.save1(dto);
		//resp.getWriter().print("<h1>done<h1>");
		//req.getRequestDispatcher("LoginPage.html").include(req, resp);
		resp.getWriter().print("<h1> Successfull you are booking</h1>");
		req.setAttribute("list", dao.fetchAll());
		req.getRequestDispatcher("result.jsp").include(req, resp);
	}
	

}
