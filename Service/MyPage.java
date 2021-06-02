package Service;

import java.util.List;

import DAO.MyPageDAO;
import VO.LoginVO;
import VO.MyPageVO;

public class MyPage {
/**
 * 회원정보 출력 메소드
 * @author PC-05
 *
 */	
	public static List<LoginVO> myInforSearch(String inputMemId) throws Exception {
		MyPageDAO dao = new MyPageDAO();
		List<LoginVO> list = dao.getList(inputMemId);
		return list;
	}

	
/**
 * 회원이 배팅한 모든 게임 출력 메소드
 * @param inputMemId
 * @return 
 * @return
 * @throws Exception
 */
	public static  List<MyPageVO> myGameSearch(String inputMemId) throws Exception {
		MyPageDAO dao = new MyPageDAO();
		List<MyPageVO> list = dao.selectBettingHistory(inputMemId);
		return list;
	}
}
