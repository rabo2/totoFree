package Controller;

import View.MainView;

public class RefundsController {
	public static void main(String[] args) {
		controller();
	}
	public static void controller() {
		MainView getinstace = MainView.getinstace();
		int refundsNum = getinstace.refundsMenu();
		do {
			switch(refundsNum) {
			case 131:
				getinstace.refunds();
				controller();
				break;
			case 132:
				MainPageController.controller();
				break;
			}
		}while(refundsNum == 131 || refundsNum == 132 || refundsNum == 133);
		
	}
}
