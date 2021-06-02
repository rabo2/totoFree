package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VO.myGameAndResultVO;

public class RefundsDAO {
	public String selectChoiceResult(String inputMemId, String inputGameId) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT CHOICE_RESULT ");
		sql.append("  FROM BETTING ");
		sql.append(" WHERE MEM_ID = ? ");
		sql.append("   AND GAME_NO =?");
		PreparedStatement statement = DbConnect.getConnection(sql);
		String memId = inputMemId;
		String gameNo = inputGameId;
		statement.setString(1, memId);
		statement.setString(2, gameNo);
		ResultSet result = statement.executeQuery();
		String choiceResult = null;
		if (result.next()) {
			choiceResult = result.getString("CHOICE_RESULT");
		}
		DbConnect.close();
		statement.close();
		result.close();
		return choiceResult;
	}

	public String selectGameResult(String inputGameNo) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT GAME_RESULT ");
		sql.append("  FROM RESULT ");
		sql.append(" WHERE GAME_NO = ? ");
		PreparedStatement statement = DbConnect.getConnection(sql);
		String gameNo = inputGameNo;
		statement.setString(1, gameNo);
		ResultSet result = statement.executeQuery();
		String gameResult = null;
		if (result.next()) {
			gameResult  = result.getString("GAME_RESULT");
		}
		DbConnect.close();
		statement.close();
		result.close();
		return gameResult;

	}
	
	public void updateMemPoint (String inputMemId, String inputGameNo) throws Exception {
		StringBuilder sql = new StringBuilder();
		String memId = inputMemId;
		String gameNo = inputGameNo;
		sql.append("UPDATE MEMBER A");
		sql.append("   SET POINT =  ");
		sql.append(" (SELECT A.POINT + B.BETTING_AMOUNT*C.RESULT_RATE ");
		sql.append("    FROM BETTING B, RESULT C");
		sql.append(" WHERE B.GAME_NO = C.GAME_NO ");
		sql.append("   AND B.MEM_ID = ?");
		sql.append("   AND B.GAME_NO = ?) ");
		sql.append(" WHERE A.MEM_ID = ? ");
		PreparedStatement statement = DbConnect.getConnection(sql);
		statement.setString(1, memId);
		statement.setString(2, gameNo);
		statement.setString(3, memId);
		statement.executeUpdate();
		DbConnect.close();
		statement.close();
	}

	public void deleteBettingHistory(String inpuMemId, String inputGameNo) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM BETTING ");
		sql.append(" WHERE GAME_NO = ? AND MEM_ID = ? ");
		PreparedStatement statement = DbConnect.getConnection(sql);
		statement.setNString(1, inputGameNo);
		statement.setString(2, inpuMemId);
		statement.executeUpdate();
		DbConnect.close();
		statement.close();
	}
	
	public void insertRefundsHistory(String inputMemId, String inputGameNo) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO REFUNDS_HISTORY(GAME_NO, MEM_ID)");
		sql.append(" VALUES (?, ?)");
		PreparedStatement statement = DbConnect.getConnection(sql);
		statement.setString(1, inputGameNo);
		statement.setString(2, inputMemId);
		statement.executeUpdate();
		DbConnect.close();
		statement.close();
	}
	
	public String increasePoint (String inputMemId, String inputGameNo) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT B.BETTING_AMOUNT*D.RESULT_RATE AS RESULT ");
		sql.append("  FROM MEMBER A, BETTING B, GAME C, RESULT D ");
		sql.append(" WHERE A.MEM_ID = B.MEM_ID ");
		sql.append("   AND B.GAME_NO = C.GAME_NO ");
		sql.append("   AND C.GAME_NO = D.GAME_NO ");
		sql.append("   AND A.MEM_ID = ? ");
		sql.append("   AND D.GAME_NO = ?");
		PreparedStatement statement = DbConnect.getConnection(sql);
		String memId = inputMemId;
		String gameNo = inputGameNo;
		statement.setString(1, memId);
		statement.setString(2, gameNo);
		ResultSet result = statement.executeQuery();
		String refundsResult = null;
		if(result.next()) {
			refundsResult = result.getNString("RESULT");
		}
		DbConnect.close();
		statement.close();
		result.close();
		return refundsResult;
	}
	
	public List<myGameAndResultVO> myGameAndResult(String inputMemId) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT SUBSTR(A.GAME_DATE,1,11), A.GAME_NO, A.HOME_TEAM, A.AWAY_TEAM, B.CHOICE_RESULT, B.BETTING_AMOUNT, C.GAME_RESULT, C.RESULT_RATE ");
		sql.append("  FROM GAME A, BETTING B, RESULT C");
		sql.append(" WHERE A.GAME_NO = B.GAME_NO");
		sql.append("   AND B.GAME_NO = C.GAME_NO");
		sql.append("   AND B.MEM_ID = ? ");
		PreparedStatement statement = DbConnect.getConnection(sql);
		statement.setString(1, inputMemId);
		ResultSet result = statement.executeQuery();
		List<myGameAndResultVO> arrayList = new ArrayList<myGameAndResultVO>();
			while(result.next()) {
				String gameDate = result.getString("SUBSTR(A.GAME_DATE,1,11)");     
				String gameNo = result.getString("GAME_NO");       
				String homeTeam = result.getString("HOME_TEAM");     
				String awayTeam = result.getString("AWAY_TEAM");     
				String choiceResult = result.getNString("CHOICE_RESULT"); 
				String bettingAmount= result.getString("BETTING_AMOUNT");
				String gameResult = result.getString("GAME_RESULT");   
				String refundsRate = result.getString("RESULT_RATE");
				arrayList.add(new myGameAndResultVO(gameDate, gameNo, homeTeam, awayTeam, choiceResult, bettingAmount, gameResult, refundsRate));
			
		}
		return arrayList;	
		}
	}
	
	
