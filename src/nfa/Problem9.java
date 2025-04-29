package nfa;

import core.Constants;

import java.util.Map;

import static java.util.Map.entry;

public class Problem9 {
    private int[] states;
    private int[] startState;
    private int[] finalState;
    private char[] alphabet;
    private Map<Integer, int[][]> transitionTable;
    private NFA nfa;
    public Problem9(String input){
        states = new int[]{0,1,2,3};
        startState = new int[]{0};
        finalState = new int[]{0,1,2};
        alphabet = new char[]{Constants.EPSILON,'0','1'};
        initTransitions();
        initNFA();
        System.out.println(nfa.isAccepted(input));
    }
    private void initTransitions(){
        transitionTable = Map.ofEntries(
                entry(0,new int[][]{{-1},{0,2},{1}}),
                entry(1, new int[][]{{-1},{2},{1}}),
                entry(2,new int[][]{{-1},{3},{1}}),
                entry(3,new int[][]{{-1},{3},{3}})
        );
    }
    private void initNFA(){
        nfa = new NFA(startState,states,finalState,alphabet,transitionTable);
    }
}
