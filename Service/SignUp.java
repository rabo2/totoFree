package Service;

import java.util.regex.Pattern;

import DAO.SignUpDAO;
import VO.SignUpVO;

public class SignUp {
	/**
	 * 회원가입 메소드 입력 순으로 뷰 구현
	 * 
	 * @param vo
	 *            회원 가입 정보 입력
	 * @throws Exception
	 * @throws NumberFormatException
	 */
	public static void signUp(SignUpVO vo) throws Exception {
		SignUpDAO signUpDAO = new SignUpDAO();
		if (signUpDAO.selectAllmemberId().contains(vo.getId())) {
			System.out.println("이미 존재하는 ID입니다.");
			Exception e = new Exception();
			throw e;
		}
		if (!vo.getPw().equals(vo.getPw2())) {
			System.out.println("비밀번호가 다릅니다.");
			Exception e = new Exception();
			throw e;
		}
		boolean check = Pattern.matches("^\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])\\-[1-4][0-9]{6}$",
				vo.getRegno());
		if (check == true) {
			int age = Integer.parseInt(vo.getRegno().substring(0, 2));
			char ch = vo.getRegno().charAt(7);
			if (ch == '1' || ch == '2') {
				age = 2021 - (1900 + age) + 1;
			} else if (ch == '3' || ch == '4') {
				age = 2021 - (2000 + age) + 1;
			}
			if (age < 20) {
				System.out.println("미성년자 가입불가");
				Exception e = new Exception();
				throw e;
			} else {
				signUpDAO.insertSignUp(vo);
			}
		} else {
			System.out.println("주민번호 형식을 확인해주세요");
			Exception e = new Exception();
			throw e;
		}
	}

}
// 주민번호 형식 넣기