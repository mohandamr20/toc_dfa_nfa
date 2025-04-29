package nfa;

import core.Constants;

import java.util.Map;

import static java.util.Map.entry;

public class Problem10 {
    private int[] states;
    private int[] startState;
    private int[] finalState;
    private char[] alphabet;
    private Map<Integer, int[][]> transitionTable;
    private NFA nfa;
    public Problem10(String input){
        states = new int[]{0,1,2};
        startState = new int[]{0};
        finalState = new int[]{0,1};
        alphabet = new char[]{Constants.EPSILON,'x','y'};
        initTransitions();
        initNFA();
        System.out.println(nfa.isAccepted(input));
    }
    private void initTransitions(){
        transitionTable = Map.ofEntries(
                entry(0,new int[][]{{-1},{0},{1}}),
                entry(1, new int[][]{{-1},{0},{2}}),
                entry(2,new int[][]{{-1},{2},{2}})
        );
    }
    private void initNFA(){
        nfa = new NFA(startState,states,finalState,alphabet,transitionTable);
    }
}
