package com.screen.main;

import com.screen.Screen;

public class Exit extends Screen {

	private static Screen screen = null;
	
	private Exit() {
		this.setPreviousScreen(Screen.MAIN_SCREEN);
	}
	
	public static Screen getInstance() {
		if (screen == null) {
			return new Exit();
		}
		
		return screen;
	}
	@Override
	public void display() {
		System.out.println("Goodbye!");
	}

	@Override
	public Screen acceptCommand() {
		return null;
	}

}
