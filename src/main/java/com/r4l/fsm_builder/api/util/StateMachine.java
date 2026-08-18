package com.r4l.fsm_builder.api.util;

import java.util.ArrayList;
import java.util.List;

public class StateMachine {
	
	private State currentState;
	
	private List<State> states;
	
	public StateMachine(State s0){
		currentState = s0;
		states = new ArrayList<>();
	}
	
	public void addState(State s) {
		states.add(s);
	}
	
	public State processChar(char c) throws Exception {
		State s = currentState.processChar(c);
		if(s == null) throw new Exception("State machine ran out of links while still running on" + currentState.getName());
		
		if(!states.contains(s)) throw new Exception("State" + s.getName() + " was not added to the state machine but is linked from State " + currentState.getName());
		
		currentState = s;
		return s;
		
	}
	
	public void setCurrentState(State state) {
		this.currentState = state;
	}
	
	public State getCurrentState() {
		return currentState;
	}

}
