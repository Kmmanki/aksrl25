package org.kakarrot.baisccontroller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
		List<String> fnames = new ArrayList<String>(); 
		
		parts.forEach(part ->{
			
			System.out.println("파일이름은: "+part.getSubmittedFileName());
			
			
			if(part.getName().equals("fs") && !(part.getSubmittedFileName().equals(""))) {
//				System.out.println("파일명: "+part.getSubmittedFileName());
//				System.out.println("파일 사이즈: "+part.getSize());
//				
			try {
				InputStream in = part.getInputStream();
				String fname = System.currentTimeMillis()+"_"+part.getSubmittedFileName();
				fnames.add(fname);
				File file =
						new File("C:\\zzz\\upload\\"+fname);
				FileUtils.copyInputStreamToFile(in, file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
			
			
		});
		req.setAttribute("fnames", fnames);
		System.out.println("내 생각에는  여기가 1번");
		System.out.println(req.getAttribute("fnames"));
		req.getRequestDispatcher("/board/register").forward(req, resp);
//		
//		
	}
       
    

}
