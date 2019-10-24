package org.kakarrot.baisccontroller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
//fileview?%fname=a.jpg
@WebServlet("/fileview")
public class FileViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = request.getParameter("fname");		
		System.out.println(fname);
	
		fname = new String(fname.getBytes("UTF-8"), "8859_1"); // UTF-8로 처리하지말고 영문으로 해라 
		File file = new File("C:\\zzz\\upload\\"+fname);
		Path path = file.toPath();
		String mimetype = Files.probeContentType(path);
		
		System.out.println(fname);

		System.out.println(mimetype);
		
		String pattern = "^([\\S]+(\\.(?i)(jpeg|jpg|png|gif|bmp))$)";
		System.out.println(fname.matches(pattern));
		String contentType="";
		
		if(fname.matches(pattern)) {
			contentType = fname.matches(pattern) ? mimetype : "application/octet-stream";
			response.setHeader("Content-Disposition","attachment; filename="+fname+";"); //여기 문제
		}else {}
		
		System.out.println(contentType);
		
		response.setContentType(contentType); // 무조건 다운로드(octet) 
		System.out.println(response.getContentType());
		
		OutputStream os = response.getOutputStream();
		
		FileUtils.copyFile(file, os);
	
	}


}
