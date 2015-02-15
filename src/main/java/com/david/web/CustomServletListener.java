	package com.david.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomServletListener implements ServletContextListener
{

	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent sce)
	{
		// TODO Auto-generated method stub
		ServletContext context = sce.getServletContext();
		String config = context.getInitParameter("contextConfigLocation");
		ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
		context.setAttribute("ApplicationContext", ctx);
	}

}
