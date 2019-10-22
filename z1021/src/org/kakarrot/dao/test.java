package org.kakarrot.dao;

import org.kakarrot.domain.BoardVO;

public class test {

	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.selectOne(1L);
		System.out.println(vo);
	}

}
