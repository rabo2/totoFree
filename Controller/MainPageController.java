package Controller;

import View.MainView;

public class MainPageController {
	public static void controller() {
		MainView getinstace = MainView.getinstace();
		int mainNum = getinstace.mainPage();
		do {
			switch (mainNum) {
			case 11:
				MyPageController.controller();
				break;
			case 12:
				GamePageController.controller();
				break;
			case 13:
				RefundsController.controller();
				break;
			case 14:
				getinstace.quit();
				mainNum = 0;
				break;
			}
		} while (mainNum == 11 || mainNum == 12 || mainNum == 13);
	}

}
