package com.ruegnerlukas.simpleutils.input.actions;

import com.ruegnerlukas.simpleutils.input.InputManager.InputState;

public class KeyAction extends InputAction {


	private final String name;
	private final InputState state;
	private final int keycode;
	
	
	
	
	public KeyAction(String name, InputState state, int keycode) {
		this.name = name;
		this.state = state;
		this.keycode = keycode;
	}
	
	
	
	
	
	@Override
	public String getName() {
		return this.name;
	}
	
	
	public InputState getState() {
		return this.state;
	}
	
	
	public int getKeyCode() {
		return this.keycode;
	}
	
	
	
}
