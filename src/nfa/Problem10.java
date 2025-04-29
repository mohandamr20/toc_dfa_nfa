package nfa;

import core.BasicProblem;
import core.Constants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

import static java.util.Map.entry;

public class Problem10 extends BasicProblem {
    private int[] states;
    private int[] startState;
    private int[] finalState;
    private char[] alphabet;
    private Map<Integer, int[][]> transitionTable;
    private NFA nfa;
    public Problem10(BufferedReader br, BufferedWriter bw) throws IOException {
        initProblem(bw);
       nfa.solveProblem(br,bw);
    }

    private void initProblem(BufferedWriter bw) throws IOException {
        states = new int[]{0,1,2};
        startState = new int[]{0};
        finalState = new int[]{0,1};
        alphabet = new char[]{Constants.EPSILON,'x','y'};
        initTransitions();
        initNFA();
        bw.append("10").append("\n");
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
