package org.zerock.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.zerock.dao.util.MybatisLoader;

public class TimeDAOimpl implements TimeDAO {

	private SqlSessionFactory factory = MybatisLoader.INSTANCE.getFactory();
	
	@Override
	public String getTime() {
//		try {
//			String resource = "mybatis-config.xml";
//			InputStream inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			System.out.println(sqlSessionFactory);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		String result = null;
		
		try (SqlSession session = factory.openSession()) {
			
			result = session.selectOne("org.zerock.dao.TimeMapper.getTime");
			System.out.println(result);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


}
