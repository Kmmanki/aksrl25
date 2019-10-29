package org.kakarrot.baisccontroller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kakarrot.requestmapping.RequestMapping;

public abstract class BasicController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Class<?> clz = this.getClass();
		String clpath = req.getRequestURI();
		String cltype = req.getMethod();
		System.out.println(clpath);
		try {
			Method[] methods = clz.getDeclaredMethods();
			Method target = null;
			
			for(Method m : methods) {
				RequestMapping anno = m.getDeclaredAnnotation(RequestMapping.class);
//				System.out.println("--------------------------------------------------------");
//				System.out.println("clpath : "+clpath);
//				System.out.println("anno.value() : "+anno.value());
//				System.out.println("=========================================================");
//				System.out.println("cltype : "+cltype);
//				System.out.println("anno.type : "+anno.type());
//				System.out.println("--------------------------------------------------------");
				if(clpath.equals(anno.value()) && cltype.equals(anno.type())) {
					target = m;
					break;
				}
				
			}
			System.out.println("bisc: "+req.getAttribute("fnames"));
			
			
			System.out.println("�� ��������  ���Ⱑ 2��");
			String result = (String)target.invoke(this, req, resp); // �˸´� �޼ҵ� ���� 
			System.out.println("Ÿ�� ������");
			if(result.startsWith("redirect:")){ // result �� redirect: �� �����Ѵٸ� 
				resp.sendRedirect(result.substring(10));  // redirect �Ѵ�.  �Ű����� ��ġ�� �̵��Ѵ�.
//				/WEB-INF/views/board/list.jsp
			}else {
				System.out.println("/WEB-INF/views"+result+".jsp");
				req.getRequestDispatcher("/WEB-INF/views"+result+".jsp")// redirec�� �ƴ϶�� result�� forward �̵��Ѵ�.
				.forward(req, resp);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	
	
	
	}
	
	protected Cookie checkCookieExist(HttpServletRequest req, String cookieName) {
		
		Cookie[] cks = req.getCookies();
		
		if(cks == null || cks.length == 0) {
			return null;
		} 
		
		Optional<Cookie> result =
		Arrays.stream(cks)
		.filter(ck -> ck.getName().equals(cookieName))
		.findFirst();
		
		return result.isPresent()? result.get():null;

	}
	
	protected boolean checkCookieValue( Cookie targetCookie, String parameter, String token) {
		String[] str = targetCookie.getValue().split(token);
		Optional<String> result = 
				Arrays.stream(str)
				.filter(s -> s.equals(parameter))
				.findFirst();
		return result.isPresent();
	}
	
	
}
