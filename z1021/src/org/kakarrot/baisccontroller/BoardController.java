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

	private final BoardDAO bd; // list 불러오기위한 작업

	public BoardController() { // board controller 불러오기 위해선 BoardDAO 가 필요하다 .
		this.bd = new BoardDAOImpl();
	}

	// get 방식의 list로 이동한다.
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

//	get방식으로 조회한다.
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
			System.out.println("쿠키발행   " + ck);
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

	// get 방식의 레지스터 - > 입력란만 주는 register
	@RequestMapping(value = "/board/register", type = "GET")
	public String getRegister(HttpServletRequest req, HttpServletResponse resp) {

		return "/board/register";
	}

	// post 방식의 레지스터 - > 입력받은 값을 넘겨서 받는 레지스터
	@RequestMapping(value = "/board/register", type = "POST")
	public String setRegister(HttpServletRequest req, HttpServletResponse resp) {
		// 파라미터 수집하자
		// select nextval 만들기
		Long nval = (long) bd.getnextval();
		System.out.println("내 생각에는  여기가 3번");
//		System.out.println("board: "+req.getAttribute("fnames"));
		List<String> li = (List<String>) req.getAttribute("fnames");

		// 보드 인서트
		BoardVO vo = new BoardVO();
		vo.setPno(nval); // 여기 수정 요망
		vo.setTitle(req.getParameter("title"));
		vo.setWriter(req.getParameter("writer"));
		vo.setContent(req.getParameter("content"));
		System.out.println(bd.insert(vo));

		// nval,li 이용해서 table_uploadfile
//		System.out.println("fname test: -------------------------------");
		if (li != null) { // 파일이 있다면
			FileUploadVO fvo = new FileUploadVO();
			for (String filename : li) {
				fvo.setBoard_no(nval);
				fvo.setF_name(filename);

				System.out.println("파일 insert 성공 했니?:   " + bd.insertfile(fvo));

			}

		}

		return "redirect:/board/list";
	}

}
