package org.kakarrot.dao;

import java.util.List;

import javax.servlet.Servlet;

import org.apache.catalina.core.ApplicationContext;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.kakarrot.domain.BoardVO;
import org.kakarrot.domain.FileUploadVO;
import org.kakarrot.dto.Paging;

public class BoardDAOImpl implements BoardDAO {
	private SqlSessionFactory sqlsessionfactory = BoardFactory.instance.getBoardFactory();

	@Override
	public boolean insert(BoardVO vo) {
		boolean W =false;
		try (SqlSession session = sqlsessionfactory.openSession()) {
			session.insert("org.kakarrot.dao.BoardMapper.insertOne", vo);
			session.commit();
			W= true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return W;
	}

	@Override
	public BoardVO selectOne(Long key) {
		BoardVO vo = null;
		try (SqlSession session = sqlsessionfactory.openSession()) {
			 vo = session.selectOne("org.kakarrot.dao.BoardMapper.selectOne", key);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return vo;
	}

	@Override
	public boolean update(BoardVO vo) {
		boolean W =false;
		try (SqlSession session = sqlsessionfactory.openSession()) {
			 session.update("org.kakarrot.dao.BoardMapper.update", vo);
			 session.commit();
			 W = true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return W;
	}

	@Override
	public boolean delete(Long key) {
		boolean W =false;
		try (SqlSession session = sqlsessionfactory.openSession()) {
			 session.delete("org.kakarrot.dao.BoardMapper.delete", key);
			 session.commit();
			 W =true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return W;
	}

	@Override
	public List<BoardVO> getList(Paging dto) {

		List<BoardVO> list = null;
		try (SqlSession session = sqlsessionfactory.openSession()) {
			list = session.selectList("org.kakarrot.dao.BoardMapper.selectList", dto);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;
	}

	@Override
	public int getCount() {
		Integer count = null;
		try (SqlSession session = sqlsessionfactory.openSession()) {
			count = session.selectOne("org.kakarrot.dao.BoardMapper.getCount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int getnextval() {
		Integer nextval = null;
		try (SqlSession session = sqlsessionfactory.openSession()) {
			nextval = session.selectOne("org.kakarrot.dao.BoardMapper.nextval");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nextval;
	}

	@Override
	public boolean insertfile(FileUploadVO fvo) {
		boolean W =false;
		try (SqlSession session = sqlsessionfactory.openSession()) {
			session.insert("org.kakarrot.dao.BoardMapper.insertfile", fvo);
			session.commit();
			 W =true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return W;
	}

	@Override
	public boolean updateViewCnt(Long pno) {
		
		int result = 0;
		try (SqlSession session = sqlsessionfactory.openSession()) {
			result = session.insert("org.kakarrot.dao.BoardMapper.updateViewCnt", pno);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return result == 1;
	}

}
