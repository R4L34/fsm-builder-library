package com.r4l.fsm_builder.api.util;

public class Link {
	
	private State initial;
	
	private State destination;
	
	private ICondition condition;
	
	public Link(State initial, State destination, ICondition condition) {
		this.condition = condition;
		this.initial = initial;
		this.destination = destination;
	}
	
	
	public boolean processCondition(char c) {
		return condition.onCondition(c);
	}
	
	
	public State getInitial() {
		return initial;
	}


	public State getDestination() {
		return destination;
	}

}
