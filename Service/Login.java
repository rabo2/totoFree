package Service;

import java.util.Map;

import DAO.LoginDAO;

public class Login {
	/**
	 * 로그인 구현 메소드
	 * 
	 * @param memId
	 *            처음 입력한 로그인 id로 다른 메소드의 매개변수로 이용
	 * @param password
	 *            비밀번호
	 * @throws Exception
	 */
	public static void login(String memId, String password) throws Exception {
		LoginDAO loginDAO = new LoginDAO();
		Map<String, String> allMember = loginDAO.selectMemberData();
		if (allMember.containsKey(memId)&&allMember.containsValue(password)) {
				System.out.println("\t\t====" + memId + "님 환영합니다====");
			} else {
				System.out.println("\n---------------------------------------");
				System.out.println("|                                     |");
				System.out.println("| 입력한 ID와 패스워드를 확인해주세요 |");
				System.out.println("|                                     |");
				System.out.println("---------------------------------------\n");
				Exception e = new Exception();
				throw e;
			}
	}
}
