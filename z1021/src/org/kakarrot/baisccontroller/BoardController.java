package org.kakarrot.baisccontroller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kakarrot.dao.BoardDAO;
import org.kakarrot.dao.BoardDAOImpl;
import org.kakarrot.domain.BoardVO;
import org.kakarrot.domain.FileUploadVO;
import org.kakarrot.dto.PageMaker;
import org.kakarrot.dto.Paging;
import org.kakarrot.requestmapping.RequestMapping;

@WebServlet("/board/*")
public class BoardController extends BasicController {
	private static final long serialVersionUID = 1L;

	private final BoardDAO bd; // list �ҷ��������� �۾�

	public BoardController() { // board controller �ҷ����� ���ؼ� BoardDAO �� �ʿ��ϴ� .
		this.bd = new BoardDAOImpl();
	}

	// get ����� list�� �̵��Ѵ�.
	@RequestMapping(value = "/board/list", type = "GET")
	public String getList(HttpServletRequest req, HttpServletResponse resp) {
		Paging p = new Paging(req.getParameter("page"), req.getParameter("amount"));
		List<BoardVO> list = bd.getList(p);
		PageMaker pm = new PageMaker(p, bd.getCount());
		req.setAttribute("page", p);
		req.setAttribute("pm", pm);
		req.setAttribute("list", list);

		return "/board/list";
	}

//	get������� ��ȸ�Ѵ�.
	@RequestMapping(value = "/board/view", type = "GET")
	public String getView(HttpServletRequest req, HttpServletResponse resp) {

		Long pno = Long.parseLong(req.getParameter("pno"));
		BoardVO a = bd.selectOne(pno);
		req.setAttribute("vo", a);

		Cookie targetCookie = checkCookieExist(req, "RecentView");
		boolean existCookie = targetCookie != null;
		boolean already = false;
		if (existCookie) {
			already = checkCookieValue(targetCookie, req.getParameter("pno"), "%");
		}
		System.out.println("targetCookie: " + targetCookie);
		System.out.println("already" + already);

		if (existCookie == false) {
			Cookie ck = new Cookie("RecentView", req.getParameter("pno") + "%");
			ck.setPath("/board");
			ck.setMaxAge(60 * 60 * 24);
			resp.addCookie(ck);
			System.out.println("��Ű����   " + ck);
			bd.updateViewCnt(pno);
		} else {
			String value = targetCookie.getValue();
			if (!already) {
				value += req.getParameter("pno") + "%";
				targetCookie.setValue(value);
				resp.addCookie(targetCookie);
				bd.updateViewCnt(pno);
			}
		}
		return "/board/view";
		
	}

	// get ����� �������� - > �Է¶��� �ִ� register
	@RequestMapping(value = "/board/register", type = "GET")
	public String getRegister(HttpServletRequest req, HttpServletResponse resp) {

		return "/board/register";
	}

	// post ����� �������� - > �Է¹��� ���� �Ѱܼ� �޴� ��������
	@RequestMapping(value = "/board/register", type = "POST")
	public String setRegister(HttpServletRequest req, HttpServletResponse resp) {
		// �Ķ���� ��������
		// select nextval �����
		Long nval = (long) bd.getnextval();
		System.out.println("�� ��������  ���Ⱑ 3��");
//		System.out.println("board: "+req.getAttribute("fnames"));
		List<String> li = (List<String>) req.getAttribute("fnames");

		// ���� �μ�Ʈ
		BoardVO vo = new BoardVO();
		vo.setPno(nval); // ���� ���� ���
		vo.setTitle(req.getParameter("title"));
		vo.setWriter(req.getParameter("writer"));
		vo.setContent(req.getParameter("content"));
		System.out.println(bd.insert(vo));

		// nval,li �̿��ؼ� table_uploadfile
//		System.out.println("fname test: -------------------------------");
		if (li != null) { // ������ �ִٸ�
			FileUploadVO fvo = new FileUploadVO();
			for (String filename : li) {
				fvo.setBoard_no(nval);
				fvo.setF_name(filename);

				System.out.println("���� insert ���� �ߴ�?:   " + bd.insertfile(fvo));

			}

		}

		return "redirect:/board/list";
	}

}
