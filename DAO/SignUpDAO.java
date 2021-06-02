package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import VO.SignUpVO;

public class SignUpDAO {
	public int insertSignUp(SignUpVO vo) throws Exception {
		int result = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO MEMBER (MEM_ID,PASSWORD,MEM_NAME,MEM_REGNO) ");
		sql.append(" VALUES (?,?,?,?)");
		PreparedStatement pstmt = DbConnect.getConnection(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPw());
		pstmt.setString(3, vo.getName());
		pstmt.setString(4, vo.getRegno());
		result = pstmt.executeUpdate();
		DbConnect.close();
		pstmt.close();
		
		return result;

	}

	public List<String> selectAllmemberId() throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT MEM_ID FROM MEMBER");
		ResultSet result = null;
		ArrayList<String> memId = new ArrayList<String>();
		PreparedStatement statement = DbConnect.getConnection(sql);
		result = statement.executeQuery();
		while (result.next()) {
			memId.add(result.getString("MEM_ID"));

		}
		DbConnect.close();
		result.close();
		statement.close();
		return memId;
	}
}
