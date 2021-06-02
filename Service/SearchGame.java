package Service;

import java.util.List;

import DAO.searchGameDAO;
import VO.searchGameVO;

public class SearchGame {
	/**
	 * 날짜 입력 문구 출력
	 */
	public static void dateAnnounce() {
		System.out.println("날짜를 입력하세요(YYYY/MM/DD 형식으로 입력하세요)");
		System.out.print(">>>");
	}

	/**
	 * 입력날짜에 맞는 예정경기를 보여주는 메소드
	 * 
	 * @param inputDate
	 *            = scanner로 매개변수를 받을 것
	 * @throws Exception
	 */
	public static List<searchGameVO> search(String inputDate) throws Exception {
		searchGameDAO search = new searchGameDAO();
		String date = inputDate;
		/**
		 * 날짜 입력
		 */
		List<searchGameVO> select = search.selectSerchGame(date);
		return select;
	}

}