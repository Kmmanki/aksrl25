package org.kakarrot.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.kakarrot.domain.BoardVO;

public class BoardDAO {
	private SqlSessionFactory sqlsessionfactory = BoardFactory.instance.getBoardFactory();
	
	
	public BoardVO selectOne(Long pno) {
		BoardVO vo = null;
		try(SqlSession session = sqlsessionfactory.openSession()){
			vo = session.selectOne("org.kakarrot.dao.BoardMapper.selectOne" , pno);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return vo;
	}
	
	public void insertOne(BoardVO vo ) {
		try(SqlSession session = sqlsessionfactory.openSession()){	
			session.insert("org.kakarrot.dao.BoardMapper.insertOne" ,vo);
			session.commit();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
