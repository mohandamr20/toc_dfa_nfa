package nfa;
import core.Constants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;
import static java.util.Map.entry;

public class Problem8 {
    private int[] states;
    private int[] startState;
    private int[] finalState;
    private char[] alphabet;
    private Map<Integer, int[][]> transitionTable;
    private NFA nfa;
    public Problem8(BufferedReader br , BufferedWriter bw) throws IOException {
        initProblem(bw);
        nfa.solveProblem(br,bw);
    }

    private void initProblem(BufferedWriter bw) throws IOException {
        states = new int[]{0,1,2,3,4};
        startState = new int[]{0};
        finalState = new int[]{4};
        alphabet = new char[]{Constants.EPSILON,'a','b'};
        initTransitions();
        initNFA();
        bw.append("8").append("\n");
    }

    private void initTransitions(){
        transitionTable = Map.ofEntries(
                entry(0,new int[][]{{-1},{1},{0}}),
                entry(1, new int[][]{{-1},{1},{0,2}}),
                entry(2,new int[][]{{-1},{3},{2}}),
                entry(3,new int[][]{{-1},{3},{4}}),
                entry(4,new int[][]{{-1},{4},{4}})
        );
    }
    private void initNFA(){
        nfa = new NFA(startState,states,finalState,alphabet,transitionTable);
    }

}
