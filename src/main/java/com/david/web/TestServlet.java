package com.david.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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
		
		/*
		 * 使用自定义的CustomServletListener时候因为是在相应的attributes里面设置过值的所以可以通过相应属性之获取
		 */
//		ApplicationContext ctx = (ApplicationContext) context.getAttribute("ApplicationContext");
		
		/*
		 * 使用spring的自带的listener的话，可以从WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE属性中获取
		 * 当然也可以直接使用它提供的WebApplicationContextUtils.getWebApplicationContext(context)工具类就行
		 */
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
		Person person = ctx.getBean(Person.class);
		person.hello();		
	}
}
