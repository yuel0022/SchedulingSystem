package com.scheduler;

import java.util.Scanner;

public class MainController {

	private Scanner scanner;
	
	public MainController() {
		setScanner(new Scanner(System.in));
	}
	
	public void close() {
		if (scanner != null) {
			scanner.close();
		}
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
}
