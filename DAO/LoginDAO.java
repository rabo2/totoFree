package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class LoginDAO {

	// 1. 비밀번호 변경

	public int updateChangePassword(String memId, String password) {
		int result = 0;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("UPDATE MEMBER SET PASSWORD=? ");
			sql.append(" WHERE MEM_ID=?");
			PreparedStatement pstmt = DbConnect.getConnection(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, password);
			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			DbConnect.close();
		}
		return result;
	}

	// 2. 회원 탈퇴

	public int deleteMemberDate(String memId, String password) throws Exception {
		int result = 0;
		StringBuilder sql = new StringBuilder();
		PreparedStatement pstmt = null;
		try {
			sql.append("DELETE MEMBER WHERE MEM_ID=? AND PASSWORD=?");
			pstmt = DbConnect.getConnection(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, password);
			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			pstmt.close();
			DbConnect.close();
		}
		return result;

	}

	// . 4 로그인

	public Map<String, String> selectMemberData() throws Exception {
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		sql.append("SELECT MEM_ID, PASSWORD");
		sql.append("  FROM MEMBER");
		PreparedStatement pstmt = DbConnect.getConnection(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			hashMap.put(rs.getString("MEM_ID"), rs.getString("PASSWORD"));
		}
		rs.close();
		DbConnect.close();
		return hashMap;

	}

}
