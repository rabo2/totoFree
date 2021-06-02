package Controller;

import View.MainView;

public class GamePageController {
	public static void controller() {
		MainView getinstace = MainView.getinstace();
		int gamePageNum;
		do {
			gamePageNum = getinstace.gamePage();
			switch (gamePageNum) {
			case 121:
				try {
					getinstace.gameSearch();
					getinstace.betting();
				} catch (Exception e1) {

				}
				controller();
				break;
			case 122:
				try {
					getinstace.myGameList();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				controller();
				break;
			case 123:
				getinstace.teamSearch();
				controller();
				break;
			case 124:
				MainPageController.controller();
				gamePageNum = 0;
				break;
			}
		} while (gamePageNum == 121 || gamePageNum == 122 || gamePageNum == 123);
	}

}
