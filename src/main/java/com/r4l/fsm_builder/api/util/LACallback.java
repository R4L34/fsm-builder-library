package com.r4l.fsm_builder.api.util;

public interface LACallback {

	public void onStateChange(LACallback.Event event);
	
	public static class Event{
		
		public State state;
		
		public char character;
		
		public StringBuilder output;
		
		public Event (State state, char character, StringBuilder output) {
			this.state = state;
			this.character = character;
			this.output = output;
		}
		
	}
	
}
