package com.r4l.fsm_builder.api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.r4l.fsm_builder.api.util.LACallback;
import com.r4l.fsm_builder.api.util.State;
import com.r4l.fsm_builder.api.util.StateMachine;

public class LexicalAnalyser {
	
	private String input;
	
	private StringBuilder output;
	
	private StateMachine stateMachine;
	
	private LACallback callback;
	
	public LexicalAnalyser(StateMachine fsm) throws IOException {
		input = Files.readString(Path.of("input.txt"));
		output = new StringBuilder();
		this.stateMachine = fsm;
		this.callback = null;
	}
	
	
	public LexicalAnalyser(State s0) throws IOException {
		input = Files.readString(Path.of("input.txt"));
		output = new StringBuilder();
		this.stateMachine = new StateMachine(s0);
		this.callback = null;
	}


	public void startLexicalAnalisys() throws Exception {
		
		for(char character : input.toCharArray()) {
			State new_state = stateMachine.processChar(character);
			
			if(new_state.getCallback() != null) {
				new_state.getCallback().onStateChange(new LACallback.Event(new_state, character, output));	
			}
			
			if(callback != null) {
				callback.onStateChange(new LACallback.Event(new_state, character, output));	
			}
		}
		
		State last_state = stateMachine.getCurrentState();
		
		if (!last_state.isFinal()) {
			throw new Exception("FSM finished in a non final state!");
		}
		
	}
	
	public StateMachine getStateMachine() {
		return stateMachine;
	}
	
	public void setCallback(LACallback callback) {
		this.callback = callback;
	}
	
	
	
	
	

}
