package org.test.baisccontroller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.test.requestmapping.RequestMapping;

public abstract class BasicController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); // 값 넘길 때 인코딩
		Class<?> clz = this.getClass();
		String clpath = req.getRequestURI();
		String cltype = req.getMethod();
		
		try {
			Method[] methods = clz.getDeclaredMethods();
			Method target = null;
			
			for(Method m : methods) {
				RequestMapping anno = m.getDeclaredAnnotation(RequestMapping.class);
				if(clpath.equals(anno.value()) && cltype.equals(anno.type())) {
					target = m;
					break;
				}
				
			}
			String result = (String)target.invoke(this, req, resp); // 이해 안감
			
			
			if(result.startsWith("redirect:")){ // result 가 redirect: 로 시작한다면 
				resp.sendRedirect(result.substring(10));  // redirect 한다.  매개변수 위치로 이동한다.
			}else {
				req.getRequestDispatcher("/WEB-INF/views"+result+".jsp")// redirec가 아니라면 result로 forward 이동한다.
				.forward(req, resp);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	
	
	
	}
	
	
}
