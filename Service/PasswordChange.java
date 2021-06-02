package Service;

import java.util.Map;

import DAO.LoginDAO;

public class PasswordChange {
   /**
    * 비밀번호 변경 메소드
    * @param memId id를 재확인
    * @param password 기존 비밀번호
    * @param changePassword 변경할 비밀번호
 * @throws Exception 
    */
	public static void passwordChange(String memId, String password, String changePassword) throws Exception {
		LoginDAO loginDAO = new LoginDAO();
		Map<String, String> allMember = loginDAO.selectMemberData();
		if (allMember.containsKey(memId)) {
			if (allMember.containsValue(password)) {
				loginDAO.updateChangePassword(changePassword, memId);
				System.out.println("비밀번호가 변경되었습니다.");
			}else {
				System.out.println("비밀번호가 틀립니다.");
			}
		}else {
			System.out.println("존재하지 않는 ID 입니다.");
		}

	}
}
