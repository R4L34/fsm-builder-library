package com.r4l.fsm_builder;

import com.r4l.fsm_builder.api.LexicalAnalyser;
import com.r4l.fsm_builder.api.util.State;
import com.r4l.fsm_builder.api.util.StateMachine;

public class Main {
	
	public static int i = 0;

    public static void main(String[] args) throws Exception {
    	
       
    	State s0 = new State(0,true);
    	State s1 = new State(1);
    	State s2 = new State(2);
    	
    	
    	LexicalAnalyser LA = new LexicalAnalyser(s0);
    	StateMachine fsm = LA.getStateMachine();

    	
    	s0.addLink(s1, c -> c == 'A');
    	s0.addLink(s2, c -> c != 'A');
    	
    	s1.setCallback((e) -> {
    		
    		LA.getStateMachine().setCurrentState(s0);
    		
    	});
    	
    	fsm.addState(s0);
    	fsm.addState(s1);
    	fsm.addState(s2);
    	
    	LA.setCallback((e) -> {System.out.println(e.character + "" + i); }); 
    	LA.startLexicalAnalisys();
    }
}