package Controller;

import View.MainView;

public class MyPageController {
	public static void controller() {
		MainView getinstace = MainView.getinstace();
		int myPageNum = getinstace.myPage();
		do {
			switch (myPageNum) {
			case 111:
				getinstace.pointCharge();
				controller();
				break;
			case 112:
				getinstace.myInfor();
				controller();
				break;
			case 113:
				getinstace.changePassword();
				controller();
				break;
			case 114:
				getinstace.deleteAccount();
				getinstace.quit();
				break;
			case 115:
				try {
					getinstace.myGameList();
				} catch (Exception e) {
					e.printStackTrace();
				}
				controller();
				break;
			case 116:
				MainPageController.controller();
				break;
			}
		} while (myPageNum == 112 || myPageNum == 113 || myPageNum == 114 || myPageNum == 115);
	}
}
