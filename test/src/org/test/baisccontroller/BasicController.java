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
		req.setCharacterEncoding("UTF-8"); // �� �ѱ� �� ���ڵ�
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
			String result = (String)target.invoke(this, req, resp); // ���� �Ȱ�
			
			
			if(result.startsWith("redirect:")){ // result �� redirect: �� �����Ѵٸ� 
				resp.sendRedirect(result.substring(10));  // redirect �Ѵ�.  �Ű����� ��ġ�� �̵��Ѵ�.
			}else {
				req.getRequestDispatcher("/WEB-INF/views"+result+".jsp")// redirec�� �ƴ϶�� result�� forward �̵��Ѵ�.
				.forward(req, resp);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	
	
	
	}
	
	
}
