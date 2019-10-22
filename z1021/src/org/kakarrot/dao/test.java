package org.kakarrot.dao;

import java.util.List;

import org.kakarrot.domain.BoardVO;
import org.kakarrot.dto.Paging;

import lombok.extern.log4j.Log4j;

@Log4j
public class test {

	public static void main(String[] args) {
		BoardDAO dao = new BoardDAOImpl();
		Paging p = new Paging();
		p.setPage(1);
		
		List<BoardVO> list = dao.getList(p);
		list.forEach(System.out::println);
		
		System.out.println(dao.getCount());
	}

}
