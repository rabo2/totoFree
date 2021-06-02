package Controller;

import View.MainView;

public class JoinController {
	private static MainView getinstace;

	public static void controller() {
		getinstace = MainView.getinstace();
		int number = getinstace.init();
		do {
			switch (number) {
			case 0:
				try {
					number = getinstace.signUp();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 1:
				try {
					getinstace.Login();
				} catch (Exception e) {
					try {
						getinstace.Login();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				MainPageController.controller();
				break;
			case 2:
				getinstace.quit();
				break;
			}
		} while (number == 0 || number == 1);
	}
}
