package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

//JUnit Test

@Log4j
public class JDBCTests {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가 해당 위치에 없습니다.");
		}
	}
	
	@Test
	public void testConnection() {
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		try(Connection con = DriverManager.getConnection(url, "spring_db", "springdb")){
			log.info(con);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
}


















