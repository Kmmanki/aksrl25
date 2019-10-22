package org.zerock.dao;

import java.util.stream.IntStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.zerock.dao.util.MybatisLoader;
import org.zerock.domain.BoardVO;

public class BoardDAOimpl implements BoardDAO {
	
	private SqlSessionFactory factory = MybatisLoader.INSTANCE.getFactory();
	public boolean insert(BoardVO vo) {
//		try {
//			String resource = "mybatis-config.xml";
//			InputStream inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			System.out.println(sqlSessionFactory);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		boolean result = false;
		
		try (SqlSession session = factory.openSession()) {
			
			int count = session.insert("org.zerock.dao.BoardMapper.insert");
			
			session.commit();
			
			result  = count == 1 ? true:false;
			System.out.println(result);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		BoardDAO dao = new BoardDAOimpl();
		
		IntStream.range(1,10).forEach(i -> {
			BoardVO vo = new BoardVO();

			vo.setTitle("제목"+i);
			vo.setContent("내용 "+i);
			vo.setWriter("user"+i);
		});
	}
}
