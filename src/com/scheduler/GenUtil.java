package com.scheduler;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class GenUtil {

	/**
	 * Add number of days to specified date.
	 * @param date The date to add.
	 * @param days Number of days.
	 * @return
	 */
	public static Date addDays(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}
	
	/**
	 * Validates and returns a number value for task duration.
	 * @param scanner
	 * @return
	 */
	public static int getDuration(Scanner scanner) {
		String input;
		int duration = 0;
		
		while (true) {
			input = scanner.next();
			
			if (!input.matches("[0-9]*")) {
				System.out.println("Invalid number format. Please try again.");
			} else {
				duration = Integer.parseInt(input);
				
				if (duration <= 0) {
					System.out.println("Invalid value. Duration should be an integer value greater than zero.");
				} else {
					break;
				}
			}
		}
		
		return duration;
	}
}
