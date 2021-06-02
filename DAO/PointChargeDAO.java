package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PointChargeDAO {
	public List<String> selectEqaulInformation(String inputId, String inputPassword) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT MEM_ID, PASSWORD");
		sql.append("  FROM MEMBER");
		sql.append(" WHERE MEM_ID = ?");
		sql.append("   AND PASSWORD = ? ");
		PreparedStatement statement = DbConnect.getConnection(sql);
		statement.setString(1, inputId);
		statement.setString(2, inputPassword);
		ResultSet result = statement.executeQuery();
		List<String> list = new ArrayList<String>();
		if (result.next()) {
			while (result.next()) {
				list.add(result.getString("MEM_ID"));
				list.add(result.getString("PASSWORD"));
			}
		} else {
			Exception e = new Exception();
			throw e;
		}
		DbConnect.close();
		statement.close();
		result.close();
		return list;
	}
	
	
	public void updateChargePoint(String inputPoint, String inputMemId) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE MEMBER");
		sql.append("   SET POINT = POINT + ?");
		sql.append(" WHERE MEM_ID = ?");
		PreparedStatement statement = DbConnect.getConnection(sql);
		statement.setString(1, inputPoint);
		statement.setString(2, inputMemId);
		int result = statement.executeUpdate();
		if(result > 0) {
			System.out.println("인생은 한방입니다!!!");
		}
		DbConnect.close();
		statement.close();
	}
	
}
