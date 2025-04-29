package nfa;

import core.Constants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class NFA {
    private int[] states;
    private int[] startState;
    private int[] finalState;
    private char[] alphabet;
    private Map<Integer, int[][]> transitionTable;
    private boolean valid;
    public NFA(int[] startState, int[] states, int[] finalState, char[] alphabet, Map<Integer, int[][]> transitionTable) {
        this.startState = startState;
        this.states = states;
        this.finalState = finalState;
        this.alphabet = alphabet;
        this.transitionTable = transitionTable;
    }
    private boolean isFinalState(int state){
        for(int s : finalState){
            if(s == state) return true;
        }
        return false;
    }
    private int getSymbolIndex(char symbol) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == symbol) return i;
        }
        return -1;
    }
    private boolean runNfa(int currentIndex,String input,int currentState){
        int[][] nextTransition = transitionTable.get(currentState);
        if(currentIndex == input.length()){
            return isFinalState(currentState);
        }
        char currentChar = input.charAt(currentIndex);
        int charIndex = getSymbolIndex(currentChar);
        for(int nextState : nextTransition[charIndex]){
            if(nextState != -1){
                valid|= runNfa(currentIndex + 1, input, nextState);
            }
        }
        return valid;
    }
    public boolean isAccepted(String input) {
         for(int start:startState){
             valid = false;
             if (runNfa(0,input,start)){
                 return true;
             }
         }
         return false;
    }

    public void solveProblem(BufferedReader br, BufferedWriter bw) throws IOException {
        String input;
        while (!(input = br.readLine()).equals(Constants.END)){
            input = input.trim();
            if(isAccepted(input)) {
                bw.append(Constants.TRUE).append("\n");
            }else{
                bw.append(Constants.FALSE).append("\n");
            }
        }
        bw.append(Constants.X).append('\n');
    }
}
