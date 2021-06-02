package View;

import java.util.Scanner;


public enum MenuList {
	
	HOME(-1, "\n-----------------------------------------\n|\t\t\t\t\t|\n"
			+ "|  0.회원가입\t   1.로그인\t2.종료\t|\n|\t\t\t\t\t|\n"
			+ "-----------------------------------------\n"), 
	SING_UP(0, "\n=====회원가입을 진행합니다====\n"), 
	LOGIN(1, "아이디와 비밀번호를 입력하세요\n"), 
	QUIT(2,"\n(*￣▽￣)/  안녕히 가세요. 다음에 또봐요! (*￣▽￣)/ "), 
	MAIN_PAGE(10, "\n-------------------------------------------------------------------------\n|\t\t\t\t\t\t\t\t\t|\n"
			+ "|     11.마이페이지\t12.게임\t      13.결과확인\t 14.종료\t|\n|\t\t\t\t\t\t\t\t\t|\n-------------------------------------------------------------------------\n"), 
	MY_PAGE(100,"\n-------------------------------------------------------------------------------------------------------------------------\n|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n"
			+ "|     111.포인트충전\t112.내 정보조회\t   113.비밀번호 변경\t114.회원탈퇴\t115.내 게임조회\t   116.뒤로가기\t\t|\n|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n"
			+ "-------------------------------------------------------------------------------------------------------------------------\n"), 
	POINT_CHARGE(111 ,"\t\t\t=====본인확인을 위해 아이디와 비밀번호를 입력하세요====="), 
	MY_INFOR(112, "\t[ 내 정보조회 ]"),
	CHAGE_PASSWORD(113, "\t[ 본인화인을 위해 아이디와 비밀번호를 입력해주세요 ]"),
	DELETE_ACCOUNT(114, "\t[ 본인확인을 위해 아이디와 비밀번호를 입력해주세요 ]"),
	MY_GAMELIST(115, "\t\t\t[ 내 게임조회 ]\n"),
	GAME_PAGE(120, "\n-----------------------------------------------------------------------------------------\n|\t\t\t\t\t\t\t\t\t\t\t|\n"
			+ "|    121.경기조회\t122.내 게임조회\t     123.팀 정보조회\t    124.뒤로가기\t|\n|\t\t\t\t\t\t\t\t\t\t\t|\n"
			+ "-----------------------------------------------------------------------------------------\n"), 
	GAME_SEARCH(121, "\t\t[ 조회할 날짜를 입력하세요(YYYY/MM/DD형식으로) ]\n\t\t\t(예시 : 2021/04/17)"),
	BETTING(1211, "\n\n\t\t========배팅화면입니다========\n"),
	TEAM_SERACH(123, "\t\t[ 조회할 팀의 이름을 입력해주세요 ]"),
	REFUNDS_MENU(13, "\n-----------------------------------------\n|\t\t\t\t\t|\n"
			+ "|    131.결과확인\t132.뒤로가기\t|\n|\t\t\t\t\t|\n"
			+ "-----------------------------------------\n"),
	MY_GAME(131, "현재까지 배팅하신 게임 내역입니다."),
	REFUNDS(132, "결과확인 메뉴입니다. 결과를 확인하고 환급받으실 게임 번호를 입력해주세요");
	
	
	private final int menu;
	private final String menuString;

	MenuList(int menu, String menuString) {
		this.menu = menu;
		this.menuString = menuString;
	}

	public int getMenu() {
		return menu;
	}

	public String getMenuString() {
		return menuString;
	}

	public static MenuList findMenu(int number) throws MenuNotFoundException {
		for (MenuList menu : values()) {
			if (menu.getMenu() == number) {
				return menu;
			}
		}
		throw new MenuNotFoundException("선택하신 메뉴가 없습니다.");
	}

	public void display(Scanner scanner) {

	}

}
