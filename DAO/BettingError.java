package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BettingError {
	/**
	 * 사용자의 배팅금액이 현재 가지고 있는 포인트보다 적을경우 에러 발생을 위한
	 * 사용자의 현재 포인트를 조회하는 QEURY 메소드
	 * @param memId
	 * @return
	 * @throws Exception
	 */
	
	public  static long overAmount(String memId) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT POINT FROM MEMBER WHERE MEM_ID = ?");
		PreparedStatement statement = DbConnect.getConnection(sql);
		statement.setString(1, memId);
		ResultSet result = statement.executeQuery();
		long point=0;
		while(result.next()) {
			point = (long)result.getLong("POINT");
		}
		DbConnect.close();
		result.close();
		statement.close();
		return point;
	}
}
