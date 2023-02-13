package it.betacom.controller;

import java.util.Scanner;

import it.betacom.model.Account;
import it.betacom.util.ScheduledOutput;

public class Controller {
	public static void main(String[] args) {
		Account account = new Account();
		Scanner scanner = new Scanner(System.in);
		ScheduledOutput output = new ScheduledOutput();
		final Integer DEFAULT_TIMEOUT = 700;
		Character mainFlag = '9';

		Integer welcomeTimeout = DEFAULT_TIMEOUT;
		for (int i = 1; i < 4; i++) {
			output.setScheduledPrint(".", i * (welcomeTimeout / 4));
		}
		output.setScheduledPrint("Welcome to the bank!", welcomeTimeout);

		while (mainFlag == '9') {
			try {
				loop: while (true) {
					Integer optionTimeout = DEFAULT_TIMEOUT;
					output.setScheduledPrintln("\nSelect the option you need to perform:", optionTimeout);
					output.setScheduledPrintln("1 - New Account | 2 - Deposit | 3 - Withdrawal | 0 - Exit\n",
							optionTimeout);

					Character option = scanner.next().charAt(0);

					Character optionFlag = Character.toUpperCase(option);

					switch (Character.toUpperCase(optionFlag)) {
					case '1':
						account.createAccount();
						break loop;
					case '2':
						account.deposit();
						break loop;
					case '3':
						account.withdrawal();
						break loop;
					case '0':
						scanner.close();
						System.exit(0);
					default:
						optionTimeout = optionTimeout / 2;
						output.setScheduledPrintln("\nInvalid option!", optionTimeout);
						break;
					}
				}
			} catch (Exception exception) {
				System.out.println("\nSomething gone wrong!");
			} finally {
				loop: while (true) {
					Integer exitTimeout = DEFAULT_TIMEOUT;

					output.setScheduledPrintln(
							"\nPress \"9\" to perform another operation. Otherwise, press \"0\" to exit.\n",
							exitTimeout);

					Character exit = scanner.next().charAt(0);

					mainFlag = Character.toUpperCase(exit);

					switch (mainFlag) {
					case '9':
						break loop;
					case '0':
						scanner.close();
						System.exit(0);
					default:
						exitTimeout = exitTimeout / 2;
						output.setScheduledPrintln("\nInvalid option!", exitTimeout);
						break;
					}
				}
			}
		}
	}
}
