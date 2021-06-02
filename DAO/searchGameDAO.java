package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import VO.searchGameVO;

public class searchGameDAO {

	/**
	 * 일자별 경기 조회
	 * 
	 * @param date
	 *            조회하려는 날짜
	 * @return
	 * @throws Exception
	 */
	public List<searchGameVO> selectSerchGame(String date) throws Exception {
		List<searchGameVO> list = null;
		ResultSet result = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT GAME_NO, HOME_TEAM, AWAY_TEAM, HOME_RATE, DRAW_RATE, AWAY_RATE");
		sql.append("  FROM GAME");
		sql.append(" WHERE GAME_DATE = ?");
		PreparedStatement statement = DbConnect.getConnection(sql);
		statement.setString(1, date);
		result = statement.executeQuery();
		list = new ArrayList<searchGameVO>();
		while (result.next()) {
			String gameNo = result.getString("GAME_NO");
			String homeTeam = result.getString("HOME_TEAM");
			String awayTeam = result.getString("AWAY_TEAM");
			String homeTeamRate = result.getString("HOME_RATE");
			String awayTeamRate = result.getString("DRAW_RATE");
			String drawTeamRate = result.getString("AWAY_RATE");
			list.add(new searchGameVO(gameNo, homeTeam, awayTeam, homeTeamRate, awayTeamRate, drawTeamRate));
		}
		DbConnect.close();
		result.close();
		statement.close();
		return list;

	}
}
