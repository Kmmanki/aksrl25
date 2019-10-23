package org.kakarrot.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadController
 */
@WebServlet("/upload")
@MultipartConfig(
		maxFileSize = 1024*2024*10, maxRequestSize =1024*2024*50 )
public class UploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<Part> parts = request.getParts();
		parts.forEach(part -> {
			
//			System.out.printf("파라미터 명 : %s, contentType :  %s,  size : %d bytes \n", part.getName(),
//                    part.getContentType(), part.getSize());
			System.out.println(part.getSubmittedFileName());
			System.out.println(part.getSize());

		});
	}

}
