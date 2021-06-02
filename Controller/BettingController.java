package Controller;

import java.sql.SQLException;
import java.util.Scanner;

import View.MainView;

public class BettingController {
	private static Scanner scanner;

	public static void controlloer(int question) {
		MainView getinstace = MainView.getinstace();
		scanner = new Scanner(System.in);
		int nextInt;
		System.out.println("\t\t배팅하시겠습니까?\n1.네\t2.아니오");
		switch (question) {
		case 1:
			try {
				getinstace.betting();
			} catch (SQLException e) {
				
			}
			do {
				System.out.println("\t\t다른 경기에도 배팅하시겠습니까\n1.네\t2.아니오");
				nextInt = scanner.nextInt();
				if(nextInt == 1) {
						try {
							getinstace.betting();
						} catch (SQLException e) {
							
						}
				}
			} while (nextInt == 1);
			scanner.close();
		case 2:
			GamePageController.controller();
		}
	}
}
