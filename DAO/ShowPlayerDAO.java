package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import VO.ShowPlayerVO;

public class ShowPlayerDAO {
	public List<ShowPlayerVO> selectshowPlayer(String inputTeam) throws Exception {
		List<ShowPlayerVO> list = null;
		ResultSet result = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT PLAYER_NAME, BACK_NUM, HEIGHT, WEIGHT, POSITION");
		sql.append("  FROM PLAYER");
		sql.append(" WHERE TEAM_NAME = ?");
		sql.append(" ORDER BY POSITION");
		PreparedStatement statement = DbConnect.getConnection(sql);
		statement.setString(1, inputTeam);
		result = statement.executeQuery();
		list = new ArrayList<ShowPlayerVO>();
		while (result.next()) {
			String playerName = result.getString("PLAYER_NAME");
			String backNum = result.getString("BACK_NUM");
			String height = result.getString("HEIGHT");
			String weight = result.getString("WEIGHT");
			String position = result.getString("POSITION");
			list.add(new ShowPlayerVO(playerName, backNum, height, weight, position));
		}
		DbConnect.close();
		result.close();
		statement.close();
		return list;

	}
}
