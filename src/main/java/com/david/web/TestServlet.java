package com.david.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.david.dto.Person;

public class TestServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		ServletContext context = getServletContext();
		ApplicationContext ctx = (ApplicationContext) context.getAttribute("ApplicationContext");
		Person person = ctx.getBean(Person.class);
		person.hello();		
	}
}
