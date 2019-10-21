package org.zerock.test;

import java.awt.image.SampleModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.service.SampleService;


@WebServlet("/sampleA")
public class SalmpeControllor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SalmpeControllor() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET.............");
		
		req.getRequestDispatcher("/WEB-INF/views/input.jsp").forward(req, resp);		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("forword");
		
		String str = req.getParameter("text");
		
		System.out.println("str: "+str);
		
		SampleService.instace.add(str);
		
		resp.sendRedirect("/list?msg=success");
		
//		req.setAttribute("list", SampleService.instace.getList());
//		
//		req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
	}



}
