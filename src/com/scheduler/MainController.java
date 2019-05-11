package com.scheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MainController {

	private Scanner scanner;
	
	private final String VALID_CODE_FORMAT = "[0-9a-zA-Z]+";
	SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
	public MainController() {
		setScanner(new Scanner(System.in));
	}
	
	public void close() {
		if (scanner != null) {
			scanner.close();
		}
	}
	
	/**
	 * Validates plan or task Code. Code must be four letters long and should consist of only
	 * alphanumeric characters. 
	 * @param code The plan/task code.
	 * @return Is the code valid or not.
	 */
	public boolean isCodeValid(String code) {
		boolean isValid = (code == null) ? false : code.length() == 4 && code.matches(VALID_CODE_FORMAT);
		
		if (!isValid) {
			System.out.println("Invalid Code! Please try again.");
		}
		
		return isValid;
	}
	
	/**
	 * Checks if the plan or task code already existing.
	 * @param code The plan/task code.
	 * @return Is the code already existing.
	 */
	public boolean isCodeAlreadyExisting(String code) {
		return false;
	}
	
	/**
	 * Checks if date is in valid format.
	 * @param date The date parameter.
	 * @return Is the date in valid format.
	 */
	public boolean isValidDate(String date) {
		boolean isValid = (date == null);
		
		try {
			format.parse(date);
			isValid = true;
		} catch (ParseException e) {
			isValid = false;
		}
		
		if (!isValid) {
			System.out.println("Invalid date format! Please try again.");
		}
		
		return isValid;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
}
