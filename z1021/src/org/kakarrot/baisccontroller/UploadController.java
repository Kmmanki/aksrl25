package org.kakarrot.baisccontroller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;

@MultipartConfig(maxFileSize = 1024*1024*10, 
maxRequestSize = 1024*1024*50, 
fileSizeThreshold = 1024*1024,
location = "C:\\zzz\\upload")
@WebServlet("/upload")
public class UploadController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Collection<Part> parts = req.getParts();
		parts.forEach(part ->{
			System.out.println(part.getSubmittedFileName());
			System.out.println(part.getSize());
			
			try {
				InputStream in = part.getInputStream();
				File file =
						new File("C:\\zzz\\upload\\"+(System.currentTimeMillis())+"_"+part.getSubmittedFileName());
				FileUtils.copyInputStreamToFile(in, file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		});
		
		
		
	}
       
    

}
