package org.zerock.util;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public enum Util {

	INSTANCE;
	
	private DataSource ds;
	
	public DataSource getDS() {
		return ds;
	}
	
	Util() {
		
		
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        config.setJdbcUrl("jdbc:oracle:thin:@192.168.1.23:1521:ORCL");
        config.setUsername("kakarrot");
        config.setPassword("1234");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        ds = new HikariDataSource(config);

		
	}
}