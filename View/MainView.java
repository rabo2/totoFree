package View;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import Controller.GamePageController;
import Controller.RefundsController;
import DAO.BettingDAO;
import Service.Betting;
import Service.DeleteAccount;
import Service.MyPage;
import Service.PasswordChange;
import Service.PointCharge;
import Service.Refunds;
import Service.SearchGame;
import Service.ShowPlayer;
import Service.SignUp;
import VO.LoginVO;
import VO.MyPageVO;
import VO.SignUpVO;
import VO.myGameAndResultVO;
import VO.searchGameVO;

public class MainView {

	private static MainView instance = new MainView();
	private Scanner scanner = ScannerUtil.scanner();
	private String inputMemId = null;

	public void setInputMemId(String inputMemId) {
		this.inputMemId = inputMemId;
	}

	public MainView() {
	}

	public MainView(String inputMemId) {
		this.inputMemId = inputMemId;
	}

	public static MainView getinstace() {
		return instance;
	}

	public int init() {
		System.out.println("\r\n" + 
				"                    ___                         ___                    ___           ___           ___           ___     \r\n" + 
				"                   /\\  \\                       /\\  \\                  /\\__\\         /\\  \\         /\\__\\         /\\__\\    \r\n" + 
				"      ___         /::\\  \\         ___         /::\\  \\                /:/ _/_       /::\\  \\       /:/ _/_       /:/ _/_   \r\n" + 
				"     /\\__\\       /:/\\:\\  \\       /\\__\\       /:/\\:\\  \\              /:/ /\\__\\     /:/\\:\\__\\     /:/ /\\__\\     /:/ /\\__\\  \r\n" + 
				"    /:/  /      /:/  \\:\\  \\     /:/  /      /:/  \\:\\  \\            /:/ /:/  /    /:/ /:/  /    /:/ /:/ _/_   /:/ /:/ _/_ \r\n" + 
				"   /:/__/      /:/__/ \\:\\__\\   /:/__/      /:/__/ \\:\\__\\          /:/_/:/  /    /:/_/:/__/___ /:/_/:/ /\\__\\ /:/_/:/ /\\__\\\r\n" + 
				"  /::\\  \\      \\:\\  \\ /:/  /  /::\\  \\      \\:\\  \\ /:/  /          \\:\\/:/  /     \\:\\/:::::/  / \\:\\/:/ /:/  / \\:\\/:/ /:/  /\r\n" + 
				" /:/\\:\\  \\      \\:\\  /:/  /  /:/\\:\\  \\      \\:\\  /:/  /            \\::/__/       \\::/~~/~~~~   \\::/_/:/  /   \\::/_/:/  / \r\n" + 
				" \\/__\\:\\  \\      \\:\\/:/  /   \\/__\\:\\  \\      \\:\\/:/  /              \\:\\  \\        \\:\\~~\\        \\:\\/:/  /     \\:\\/:/  /  \r\n" + 
				"      \\:\\__\\      \\::/  /         \\:\\__\\      \\::/  /                \\:\\__\\        \\:\\__\\        \\::/  /       \\::/  /   \r\n" + 
				"       \\/__/       \\/__/           \\/__/       \\/__/                  \\/__/         \\/__/         \\/__/         \\/__/    \r\n" + 
				"");
		System.out.print(MenuList.HOME.getMenuString());
		return scanner.nextInt();
	}

	public int getMenu() {
		return scanner.nextInt();
	}

	public int signUp() {
		int number;
		System.out.println(MenuList.SING_UP.getMenuString());
		System.out.println("--------------------------------");
		System.out.print("아이디 : ");
		String signId = scanner.next();
		System.out.print("패스워드 : ");
		String password = scanner.next();
		System.out.print("패스워드 재확인 : ");
		String password2 = scanner.next();
		System.out.print("이름 : ");
		String name = scanner.next();
		System.out.print("주민번호('-' 입력) : ");
		String regno = scanner.next();
		try {
			SignUp.signUp(new SignUpVO(signId, password, password2, name, regno));
			number = 1;
		} catch (Exception e) {
			System.out.println("가입이 불가능합니다.");
			number = 0;
		} finally {
			System.out.println("--------------------------------");
		}
		return number;
	}

	public void Login() throws Exception {
		System.out.println("---------LOGIN---------");
		System.out.print("   ID : ");
		String inputId = scanner.next();
		setInputMemId(inputId);
		System.out.print("PASSWORD : ");
		String password = scanner.next();
		System.out.println("-----------------------");
		Service.Login.login(inputMemId, password);
	}

	public void quit() {
		System.out.println(MenuList.QUIT.getMenuString());
		System.exit(0);
	}

	public int mainPage() {
		System.out.println(MenuList.MAIN_PAGE.getMenuString());
		return scanner.nextInt();
	}

	public int myPage() {
		System.out.println(MenuList.MY_PAGE.getMenuString());
		return scanner.nextInt();
	}

	public void pointCharge() {
		System.out.println(MenuList.POINT_CHARGE.getMenuString());
		System.out.print("ID : ");
		String inputId = scanner.next();
		System.out.print("PASSWORD : ");
		String inputPasswrod = scanner.next();
		try {
			PointCharge.checkInfor(inputId, inputPasswrod);
		} catch (Exception e1) {
			System.out.println("\t\tㅠㅠ입력한 ID 혹은 패스워드를 다시 확인해주세요ㅠㅠ");
		}
		String point = scanner.next();
		PointCharge.chargePoint(inputId, point);
	}

	public void myInfor() {
		try {
			List<LoginVO> myInforSearch = MyPage.myInforSearch(inputMemId);
			for (LoginVO loginVO : myInforSearch) {
				System.out.println(loginVO);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void changePassword() {
		System.out.println(MenuList.CHAGE_PASSWORD.getMenuString());
		System.out.println("ID : ");
		String id = scanner.next();
		System.out.println("현재 패스워드 : ");
		String password = scanner.next();
		System.out.println("변경할 패스워드 : ");
		String changePassword = scanner.next();
		try {
			PasswordChange.passwordChange(id, password, changePassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteAccount() {
		System.out.println(MenuList.DELETE_ACCOUNT.getMenuString());
		System.out.println("ID : ");
		String id = scanner.next();
		System.out.println("패스워드 : ");
		String password = scanner.next();
		try {
			DeleteAccount.deleteAccount(id, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void myGameList() throws Exception {
		System.out.println(MenuList.MY_GAMELIST.getMenuString());
		List<MyPageVO> myGameSearch = MyPage.myGameSearch(inputMemId);
		System.out.println("게임날짜\t게임번호\t홈팀\t어웨이팀\t선택결과\t배팅금");
		System.out.println("------------------------------------------------------------------------------");
		for (MyPageVO list : myGameSearch) {
			System.out.println(list.getGameDate() + "\t" + list.getGameNo() + "\t\t" + list.getHomeTeam() + "\t"
					+ list.getAwayTeam() + "\t\t" + list.getChoiceResult() + "\t\t" + list.getBettingAmount());
		}
	}

	public int gamePage() {
		System.out.println(MenuList.GAME_PAGE.getMenuString());
		return scanner.nextInt();
	}

	public void gameSearch() throws Exception {
		System.out.println(MenuList.GAME_SEARCH.getMenuString());
		String inputDate = scanner.next();

		List<searchGameVO> select = SearchGame.search(inputDate);
		if (select.size() == 0) {
			System.out.println("\t\t-----------------------------------");
			System.out.println("\t\t해당 날짜 경기가 존재 하지 않습니다");
			System.out.println("\t\t-----------------------------------");
			Exception e = new Exception();
			throw e;
		} else {
			System.out.println("==================================" + inputDate
					+ " 경기 ==========================================");
			System.out.println("경기번호\t홈팀    :    어웨이팀\t\t홈 배당\t\t무승부\t\t어웨이 배당");
			System.out.println(
					"--------------------------------------------------------------------------------------------");
			for (searchGameVO searchGameVO : select) {
				System.out.println("   " + searchGameVO.getGameNo() + "    \t" + searchGameVO.getHomeTeam() + "\t:\t"
						+ searchGameVO.getAwayTeam() + "\t \t" + searchGameVO.getHomeTeamRate() + "\t \t"
						+ searchGameVO.getDrawTeamRate() + "\t\t" + searchGameVO.getAwayTeamRate());
			}
			System.out.println(
					"============================================================================================");
		}
	}

	public void teamSearch() {
		System.out.println("조회할 팀명을 입력하세요");
		String inputTeam = scanner.next();
		try {
			ShowPlayer.search(inputTeam);
		} catch (Exception e) {
		}

	}

	public int refundsMenu() {
		System.out.println(MenuList.REFUNDS_MENU.getMenuString());
		return scanner.nextInt();
	}

	public void myGame() {
		System.out.println(MenuList.MY_GAME.getMenuString());
		System.out.println("\n게임날짜\t게임번호\t홈팀\t어웨이팀\t선택결과\t배팅금액\t배당");
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		try {
			List<myGameAndResultVO> myGameAndResultList = Refunds.MyGameAndResultList(inputMemId);
			for (myGameAndResultVO list : myGameAndResultList) {
				System.out.println(list.getGameDate() + "\t" + list.getGameNo() + "\t\t" + list.getHomeTeam() + "\t"
						+ list.getAwayTeam() + "\t\t" + list.getChoiceResult() + "\t\t" + list.getBettingAmount()
						+ "\t\t" + list.getRefundsRate());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void betting() throws SQLException {
		System.out.println(MenuList.BETTING.getMenuString());
		System.out.println("\t\t======배팅하시겠습니까?========\n\t\t\t1.네\t2.아니오");
		int question = scanner.nextInt();
		do {
			if (question == 1) {
				System.out.println("배팅할 게임번호를 입력해주세요");
				String gameNo = scanner.next();
				BettingDAO bettingDAO = new BettingDAO();
				List<String> list = bettingDAO.selectRefundHistory(inputMemId);
				if (list.contains(gameNo)) {
					System.out.println("이미 결과를 확인해서 환급받은 게임입니다.");
					GamePageController.controller();
				}
				/**
				 * 입력한 게임번호가 이미 존재한다면 배팅이 불가능
				 */
				System.out.println("얼마를 배팅하시겠습니까");
				long inputAmount = scanner.nextLong();
				System.out.println("예상결과를 입력 해주세요 (HW :홈팀 승, AW : 어웨이팀 승, DRAW : 무승부)");
				String inputResult = scanner.next();
				
				try {
					Betting.betting(gameNo, inputMemId, inputAmount, inputResult);
					System.out.println("\n\t\t====다시 배팅하시겠습니까?=====\n\t\t\t1.네\t2.아니오");
					question = scanner.nextInt();
				} catch (Exception e) {
					System.out.println("이미 배팅한 게임입니다.");
					GamePageController.controller();
				}
			}
		} while (question == 1);
	}

	public void refunds() {
		System.out.println(MenuList.REFUNDS.getMenuString());
		System.out.println("\n게임날짜\t게임번호\t홈팀\t어웨이팀\t선택결과\t게임결과\t배당");
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		List<myGameAndResultVO> myGameAndResultList = null;
		try {
			myGameAndResultList = Refunds.MyGameAndResultList(inputMemId);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (myGameAndResultVO list : myGameAndResultList) {
			System.out.println(list.getGameDate() + "\t" + list.getGameNo() + "\t\t" + list.getHomeTeam() + "\t"
					+ list.getAwayTeam() + "\t\t" + list.getChoiceResult() + "\t\t" + list.getGameResult() + "\t\t"
					+ list.getRefundsRate());
		}
		System.out.println("\n-------------------------------------------------");
		System.out.println("|\t1.배당받기\t\t2.뒤로가기\t|");
		System.out.println("-------------------------------------------------");
		int nextInt = scanner.nextInt();
		if (nextInt == 1) {
			System.out.println("배당받을 경기번호를 입력해주세요");
			String inputNo = scanner.next();
			try {
				Refunds.refunds(inputMemId, inputNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			RefundsController.controller();
		}
	}

}
