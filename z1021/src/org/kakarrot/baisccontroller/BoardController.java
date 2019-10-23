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
       

	private final BoardDAO bd; // list �ҷ��������� �۾�
		
		public BoardController(){ // board controller �ҷ����� ���ؼ� BoardDAO �� �ʿ��ϴ� .
			this.bd = new BoardDAOImpl();
		}
	
	// get ����� list�� �̵��Ѵ�.
	@RequestMapping(value = "/board/list", type = "GET")
	public String getList(HttpServletRequest req, HttpServletResponse resp) {
		Paging p = new Paging(req.getParameter("page"),req.getParameter("amount"));
		List<BoardVO> list =bd.getList(p);
		req.setAttribute("list", list);
		return "/board/list";
	}
	
	//get ����� ��������  - > �Է¶��� �ִ� register 
	@RequestMapping(value = "/board/register", type = "GET")
	public String getRegister(HttpServletRequest req, HttpServletResponse resp) {
		
		return "/board/register";
	}
	
	//post ����� ��������  - > �Է¹��� ���� �Ѱܼ� �޴� ��������
	@RequestMapping(value = "/board/register", type = "POST")
	public String setRegister(HttpServletRequest req, HttpServletResponse resp) {
		
		return "/board/register";
	}
	
	
	@RequestMapping(value = "/board/view", type = "GET")
	public String getView(HttpServletRequest req, HttpServletResponse resp) {
		
		return "/board/View";
	}
	
	
}
