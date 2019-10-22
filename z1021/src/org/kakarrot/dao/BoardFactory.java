package org.kakarrot.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

enum BoardFactory {

	instance;
	private SqlSessionFactory sqlsessionfactory;
	
	BoardFactory(){
	
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlsessionfactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println(inputStream);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public SqlSessionFactory getBoardFactory() {
		return this.sqlsessionfactory;
	}
	


}
