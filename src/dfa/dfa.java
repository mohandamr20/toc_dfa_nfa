import java.io.*;
import java.util.*;

public class DFA {

    private int[] states;
    private int startState;
    private int[] finalStates;
    private char[] alphabet;
    private Map<Integer, int[]> transitionTable;

    public DFA() {
        
    }

    
    public void runDFA(int[] states, int startState, int[] finalStates,
                       char[] alphabet, Map<Integer, int[]> transitionTable,
                       BufferedReader br, BufferedWriter bw) {
        this.states = states;
        this.startState = startState;
        this.finalStates = finalStates;
        this.alphabet = alphabet;
        this.transitionTable = transitionTable;

        solveProblem(br, bw);
    }

    public boolean isAccepted(String s) {
        int currentState = startState;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int symbolIndex = getSymbolIndex(c);
            if (symbolIndex == -1) return false; 

            int[] transitions = transitionTable.get(currentState);
            if (transitions == null || symbolIndex >= transitions.length) return false;

            currentState = transitions[symbolIndex];
        }

        for (int finalState : finalStates) {
            if (currentState == finalState) return true;
        }
        return false;
    }

    private int getSymbolIndex(char c) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == c) return i;
        }
        return -1; 
    }

    public void solveProblem(BufferedReader br, BufferedWriter bw) {
        try {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.equals("end")) break;
                boolean result = isAccepted(line);
                bw.write(result ? "True\n" : "False\n");
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
