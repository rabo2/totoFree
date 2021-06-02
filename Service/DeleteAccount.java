package Service;

import java.util.Map;

import DAO.LoginDAO;

public class DeleteAccount {
	public static void deleteAccount(String memId, String password) throws Exception {
		LoginDAO loginDAO = new LoginDAO();
		Map<String, String> allMember = loginDAO.selectMemberData();
		if (allMember.containsKey(memId)) {
			if (allMember.containsValue(password)) {
				loginDAO.deleteMemberDate(memId, password);
				System.out.println("회원탈퇴 되셨습니다.");
				System.out.println("다시 돌아오실거죠?");
			}else {
				System.out.println("비밀번호가 틀립니다.");
			}
		}else {
			System.out.println("존재하지 않는 ID 입니다.");
		}
	}
}
