package Service;

import DAO.PointChargeDAO;

public class PointCharge {
	/**
	 * Scanner로 입력 값을 넣기 전에 출력하는 안내 문구
	 */
	public static void pointChargeAnnounce() {
		System.out.println("충전 금액을 입력해주세요");
		System.out.print(">>>");

	}
	
	/**
	 * 사용자 확인용 메소드, id와 password를 확인한다.
	 * 만약 다르면 다시 반복
	 * @param inputId 사용자 id
	 * @param inputPassword 사용자 password
	 * @throws Exception 
	 */
	public static void checkInfor(String inputId, String inputPassword) throws Exception {
		PointChargeDAO dao = new PointChargeDAO();
			dao.selectEqaulInformation(inputId, inputPassword);
			pointChargeAnnounce();
			
	}
	
	/**
	 * 사용자 point충전 메소드 MEMEBER 테이블의 POINT를 업데이트 한다.
	 * 1
	 * 
	 * @param inputId checkInfor()의 사용자 id입력 값을 그대로 받아온다.
	 * @param point 충전 금액 입력 scanner로 입력받는다.
	 * @throws Exception
	 */
	public static void chargePoint(String inputId, String point) {
		PointChargeDAO dao = new PointChargeDAO();
		try {
			dao.updateChargePoint(point, inputId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
