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
		 * ʹ���Զ����CustomServletListenerʱ����Ϊ������Ӧ��attributes�������ù�ֵ�����Կ���ͨ����Ӧ����֮��ȡ
		 */
//		ApplicationContext ctx = (ApplicationContext) context.getAttribute("ApplicationContext");
		
		/*
		 * ʹ��spring���Դ���listener�Ļ������Դ�WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE�����л�ȡ
		 * ��ȻҲ����ֱ��ʹ�����ṩ��WebApplicationContextUtils.getWebApplicationContext(context)���������
		 */
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
		Person person = ctx.getBean(Person.class);
		person.hello();		
	}
}
