package com.r4l.fsm_builder.api.util;

import java.util.ArrayList;
import java.util.List;

public class State {
	
	private int name;
	
	private List<Link> links;
	
	private LACallback callback;
	
	private boolean isFinal;
	
	public State(int name) {
		this.setName(name);
		links = new ArrayList<>();
		isFinal = false;
	}
	
	public State(int name, boolean isFinal) {
		this.setName(name);
		links = new ArrayList<>();
		this.isFinal = isFinal;
	}
	
	
	public void addLink(State destination, ICondition condition) {
		links.add(new Link(this, destination, condition));
	}
	
	public State processChar(char c) {
		for(Link link : links) {
			if(link.processCondition(c)) {		
				return link.getDestination();
			}
		}
		return null;
	}


	public int getName() {
		return name;
	}


	public void setName(int name) {
		this.name = name;
	}


	public void setCallback(LACallback callback) {
		this.callback = callback;
	}
	
	public LACallback getCallback() {
		return callback;
	}


	public boolean isFinal() {
		return isFinal;
	}


	public void setFinal() {
		this.isFinal = true;
	}

}
