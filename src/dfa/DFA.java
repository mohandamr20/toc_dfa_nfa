package dfa;

import core.Constants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

public class DFA {
    private int[] states;
    private int startState;
    private int[] finalStates;
    private char[] alphabet;
    private Map<Integer, int[]> transitionTable;

    public DFA(int[] startState, int[] states, int[] finalStates, char[] alphabet, Map<Integer, int[]> transitionTable) {
        this.startState = startState[0]; // Use the first element only
        this.states = states;
        this.finalStates = finalStates;
        this.alphabet = alphabet;
        this.transitionTable = transitionTable;
    }

    private boolean isFinalState(int state) {
        for (int s : finalStates) {
            if (s == state) return true;
        }
        return false;
    }

    private int getSymbolIndex(char symbol) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == symbol) return i;
        }
        return -1;
    }

    public boolean isAccepted(String input) {
        int currentState = startState;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            int charIndex = getSymbolIndex(currentChar);
            if (charIndex == -1) return false; // Invalid character
            int[] nextStates = transitionTable.get(currentState);
            if (nextStates == null || nextStates[charIndex] == -1) return false;
            currentState = nextStates[charIndex];
        }
        return isFinalState(currentState);
    }

    public void solveProblem(BufferedReader br, BufferedWriter bw) throws IOException {
        String input;
        while (!(input = br.readLine()).equals(Constants.END)) {
            input = input.trim();
            if (isAccepted(input)) {
                bw.append(Constants.TRUE).append("\n");
            } else {
                bw.append(Constants.FALSE).append("\n");
            }
        }
        bw.append(Constants.X).append('\n');
    }
}
