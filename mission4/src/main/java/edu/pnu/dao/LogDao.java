package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;

//드라이버랑 url 접속 하고, add 해서 stmt 해서 sql add 하고
public class LogDao {

	private String driver = "org.h2.Driver";
	private String url = "jdbc:h2:tcp://localhost/~/mission2";
	private String username = "scott";
	private String password = "tiger";

	private Connection con;

	public LogDao() { // 멤버다오 만듦과 동시에 커넥션 객체 만듦
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			System.out.println("데이터베이스가 연결되었습니다");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
