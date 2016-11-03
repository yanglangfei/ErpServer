package com.yf.erp.db;
import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DaoAccess {
	
	public static SqlSession getSession() throws IOException {
		Reader reader = Resources
				.getResourceAsReader("com/yf/config/configuration.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder()
				.build(reader);
		return factory.openSession();
	}
}
