package Service;

import DAO.BettingDAO;
import VO.BettingVO;

public class Betting {
	/**
	 * 회원이 배팅하는 메소드
	 * 
	 * @param inputGameNo
	 *            사용자가 게임정보를 확인하고 입력할 수 있도록 순서를 배치한다.
	 * @param inputMemId
	 *            사용자가 로그인할 때 입력한 ID값을 받아온다. 재입력 불필요
	 * @param inputAmount
	 *            게임 번호 선택 입력값을 받은후 scanner로 입력받는다..
	 * @param inputResult
	 *            배팅금액 입력후 scanner로 입력받는다 HW, AW, DRAW만 받을수 있도록 조건 추가.
	 * @throws Exception 
	 */
	public static void betting(String inputGameNo, String inputMemId, long inputAmount, String inputResult) throws Exception {
		BettingDAO bettingDAO = new BettingDAO();
		String gameNo = inputGameNo;
		String memId = inputMemId;
		long amount = inputAmount;
		String result = inputResult;
		bettingDAO.insertBetting(new BettingVO(gameNo, memId, amount, result));
	}
}
