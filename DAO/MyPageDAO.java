package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VO.LoginVO;
import VO.MyPageVO;

public class MyPageDAO {
	public List<LoginVO> getList(String inputMemId) {
		List<LoginVO> lists = new ArrayList<LoginVO>();
		PreparedStatement pstmt;
		ResultSet rs = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT MEM_ID,PASSWORD,MEM_NAME,MEM_REGNO, POINT ");
			sql.append("FROM MEMBER WHERE MEM_ID = ?");
			pstmt = DbConnect.getConnection(sql);
			pstmt.setString(1, inputMemId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String memId = rs.getString("MEM_ID");
				String password = rs.getString("PASSWORD");
				String memName = rs.getString("MEM_NAME");
				String memRegno = rs.getString("MEM_REGNO");
				String point = rs.getString("POINT");
				lists.add(new LoginVO(memId, password, memName, memRegno, point));
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}finally {
			DbConnect.close();
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lists;
	}

	public List<MyPageVO> selectBettingHistory(String memId) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT SUBSTR(A.GAME_DATE,1,11), A.GAME_NO, A.HOME_TEAM, A.AWAY_TEAM, B.CHOICE_RESULT, B.BETTING_AMOUNT ");
		sql.append("  FROM GAME A, BETTING B");
		sql.append(" WHERE A.GAME_NO = B.GAME_NO");
		sql.append("   AND B.MEM_ID = ? ");
		PreparedStatement statement = DbConnect.getConnection(sql);
		statement.setString(1, memId);
		ResultSet result = statement.executeQuery();
		List<MyPageVO> list = new ArrayList<MyPageVO>();
		while (result.next()) {
			String gameDate = result.getString("SUBSTR(A.GAME_DATE,1,11)");
			String gameNo = result.getString("GAME_NO");
			String homeTeam = result.getString("HOME_TEAM");
			String awayTeam = result.getString("AWAY_TEAM");
			String choiceResult = result.getString("CHOICE_RESULT");
			String bettingAmount = result.getString("BETTING_AMOUNT");
			list.add(new MyPageVO(gameDate, gameNo, homeTeam, awayTeam, choiceResult, bettingAmount));
		}
		DbConnect.close();
		result.close();
		statement.close();
		return list;
	}


}