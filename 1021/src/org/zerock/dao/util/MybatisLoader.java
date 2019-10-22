package org.zerock.dao.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public enum MybatisLoader {
	INSTANCE;
	
	private SqlSessionFactory factory;
	
	public SqlSessionFactory getFactory() {
		return this.factory;
	}
	
	MybatisLoader(){
		
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
