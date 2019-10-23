package org.kakarrot.baisccontroller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kakarrot.dao.BoardDAO;
import org.kakarrot.dao.BoardDAOImpl;
import org.kakarrot.domain.BoardVO;
import org.kakarrot.dto.Paging;
import org.kakarrot.requestmapping.RequestMapping;

@WebServlet("/board/*")
public class BoardController extends BasicController {
	private static final long serialVersionUID = 1L;
       

	private final BoardDAO bd; // list 불러오기위한 작업
		
		public BoardController(){ // board controller 불러오기 위해선 BoardDAO 가 필요하다 .
			this.bd = new BoardDAOImpl();
		}
	
	// get 방식의 list로 이동한다.
	@RequestMapping(value = "/board/list", type = "GET")
	public String getList(HttpServletRequest req, HttpServletResponse resp) {
		Paging p = new Paging(req.getParameter("page"),req.getParameter("amount"));
		List<BoardVO> list =bd.getList(p);
		req.setAttribute("list", list);
		return "/board/list";
	}
	
	//get 방식의 레지스터  - > 입력란만 주는 register 
	@RequestMapping(value = "/board/register", type = "GET")
	public String getRegister(HttpServletRequest req, HttpServletResponse resp) {
		
		return "/board/register";
	}
	
	//post 방식의 레지스터  - > 입력받은 값을 넘겨서 받는 레지스터
	@RequestMapping(value = "/board/register", type = "POST")
	public String setRegister(HttpServletRequest req, HttpServletResponse resp) {
		
		return "/board/register";
	}
	
	
	@RequestMapping(value = "/board/view", type = "GET")
	public String getView(HttpServletRequest req, HttpServletResponse resp) {
		
		return "/board/View";
	}
	
	
}
