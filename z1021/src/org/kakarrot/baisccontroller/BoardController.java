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
		req.setAttribute("page", p);
		System.out.println("page: "+p.getPage());
		req.setAttribute("list", list);
		return "/board/list";
	}

//	get������� ��ȸ�Ѵ�.
	@RequestMapping(value = "/board/view", type = "GET")
	public String getView(HttpServletRequest req, HttpServletResponse resp) {
			Long pno = Long.parseLong(req.getParameter("pno"));
		BoardVO a = bd.selectOne(pno);
	
		System.out.println("page: "+p.getPage());
		req.setAttribute("vo", a);
		return "/board/view";
	}
	
	//get ����� ��������  - > �Է¶��� �ִ� register 
	@RequestMapping(value = "/board/register", type = "GET")
	public String getRegister(HttpServletRequest req, HttpServletResponse resp) {
		
		return "/board/register";
	}
	
	//post ����� ��������  - > �Է¹��� ���� �Ѱܼ� �޴� ��������
	@RequestMapping(value = "/board/register", type = "POST")
	public String setRegister(HttpServletRequest req, HttpServletResponse resp) {
		//�Ķ���� ��������
		BoardVO vo = new BoardVO();
		vo.setTitle(req.getParameter("title"));
		vo.setWriter(req.getParameter("writer"));
		vo.setContent(req.getParameter("content"));
		System.out.println(bd.insert(vo));
		
		
		return "redirect:/list";
	}
	
	
	
	
}
