package models;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MockDao {
	SqlSessionFactory factory;
	
	public MockDao() throws IOException{
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
		factory = builder.build(is);
	}
	
	public int getlogin(Map param){
		SqlSession sql = factory.openSession();
		try {
			int s= sql.selectOne("account.getloginresult",param);
			if (s==1) {
				sql.commit();
			}
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	
	
	
}
