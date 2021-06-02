package Service;

import java.util.List;

import DAO.RefundsDAO;
import VO.myGameAndResultVO;

public class Refunds {
	/**
	 * 본인이 배팅한 게임의 목록을 보여주는 메소드
	 * 환급받기전에 결과를 확인할 때 사용, 배팅내역과 배당, 결과를 보여준다.
	 * @param inputMemId
	 * @return
	 * @throws Exception 
	 */
	public static List<myGameAndResultVO> MyGameAndResultList(String inputMemId) throws Exception {
		RefundsDAO refundsDAO = new RefundsDAO();
		List<myGameAndResultVO> list = refundsDAO.myGameAndResult(inputMemId);
		
		return list;
	}
	/**
	 * 사용자가 경기 결과확인후 배당금을 받는 메소드 구현
	 * 
	 * @param inputId
	 *            로그인시 입력한 ID값을 받아온다.
	 * @param inputNo
	 *            경기 결과를 확인하기 위해서 GAME_NO를 입력받는다. 사용자 편의를 위해서 자신이 배팅한 목록을 출력하는 메소드가
	 *            필요할수도 있다.
	 * @return 
	 * @throws Exception 
	 */
	
	public static void refunds(String inputId, String inputNo) throws Exception {
		String inputMemId = inputId;
		String inputGameNo = inputNo;
		RefundsDAO refundsDAO = new RefundsDAO();
		/**
		 * 만약 조회한 게임 결과가 사용자가 배팅한 결과와 다르다면 UPDATE되지 않음
		 */
		if (refundsDAO.selectChoiceResult(inputMemId, inputGameNo).equals(refundsDAO.selectGameResult(inputGameNo))) {
			String result = refundsDAO.increasePoint(inputMemId, inputGameNo);
			System.out.println("=============== " + result + "를 획득하셨습니다 =============");
			refundsDAO.updateMemPoint(inputMemId, inputGameNo);
			refundsDAO.insertRefundsHistory(inputMemId, inputGameNo);
			refundsDAO.deleteBettingHistory(inputMemId, inputGameNo);
			System.out.println("===============\t축하드립니다.!!!!\t=============");
		} else {
			System.out.println("다음 기회를 노려보세요 ㅜㅜ");
		}
	}
}
