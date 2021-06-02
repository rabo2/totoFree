package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VO.BettingVO;

public class BettingDAO {
	public List<String> selectRefundHistory(String inputMemId) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT GAME_NO ");
		sql.append("  FROM REFUNDS_HISTORY ");
		sql.append(" WHERE MEM_ID = ?");
		PreparedStatement statement = DbConnect.getConnection(sql);
		statement.setString(1, inputMemId);
		ResultSet result = statement.executeQuery();
		List<String> list = new ArrayList<String>();
		while (result.next()) {
			String gameNo = result.getString("GAME_NO");
			list.add(gameNo);
		}
		DbConnect.close();
		result.close();
		return list;
	}

	public void insertBetting(BettingVO vo) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO BETTING(MEM_ID,GAME_NO,BETTING_AMOUNT,CHOICE_RESULT) ");
		sql.append(" VALUES ( ?, ?, ?, ? )");
		PreparedStatement statement = DbConnect.getConnection(sql);
		statement.setString(1, vo.getMemId());
		statement.setString(2, vo.getGameNo());
		statement.setLong(3, vo.getAmount());
		statement.setString(4, vo.getResult());
		int result = 0;
		if (vo.getAmount() < BettingError.overAmount(vo.getMemId())) {
			result = statement.executeUpdate();
			if (result > 0) {
				System.out.println("좋은 결과를 기대합니다.");

			} else {
				System.out.println("입력 값을 확인해주세요");
			}
		} else {
			System.out.println("잔여 포인트가 부족합니다.");
		}
		DbConnect.close();
		statement.close();
	}

}
