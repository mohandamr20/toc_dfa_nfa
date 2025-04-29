package nfa;

import core.Constants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

import static java.util.Map.entry;

public class Problem7{
    private int[] states;
    private int[] startState;
    private int[] finalState;
    private char[] alphabet;
    private Map<Integer, int[][]> transitionTable;
    private NFA nfa;
    public Problem7(BufferedReader br, BufferedWriter bw) throws IOException {
        initProblem(bw);
        nfa.solveProblem(br,bw);
    }

    private void initProblem(BufferedWriter bw) throws IOException {
        states = new int[]{0,1,2,3,4,5,6};
        startState = new int[]{0};
        finalState = new int[]{5,6};
        alphabet = new char[]{Constants.EPSILON,'0','1'};
        initTransitions();
        initNFA();
        bw.append("7").append("\n");
    }

    private void initTransitions(){
        transitionTable = Map.ofEntries(
                entry(0, new int[][]{{-1}, {1}, {2}}),      
                entry(1, new int[][]{{-1}, {3}, {5}}),      
                entry(2, new int[][]{{-1}, {5}, {4}}), 
                entry(3, new int[][]{{-1}, {-1}, {5}}),
                entry(4, new int[][]{{-1}, {5}, {-1}}),
                entry(5, new int[][]{{-1}, {3,6}, {4,6}}),
                entry(6, new int[][]{{-1}, {-1}, {-1}})   
        );
    }
    private void initNFA(){
        nfa = new NFA(startState,states,finalState,alphabet,transitionTable);
    }
}
