import static java.util.Map.entry;
import java.io.*;
import java.util.Map;

public class Problem3 {
    public Problem3(BufferedReader br, BufferedWriter bw) {
        int[] states = {0, 1, 2, 3}; 
        int startState = 0;
        int[] finalStates = {3};
        char[] alphabet = {'x', 'y', 'z'};
        Map<Integer, int[]> transitionTable = Map.ofEntries(
            entry(0, new int[]{1, 0, 0}),
            entry(1, new int[]{1, 2, 0}),
            entry(2, new int[]{1, 0, 3}),
            entry(3, new int[]{3, 3, 3}) 
        );

        DFA dfa = new DFA();
        dfa.runDFA(states, startState, finalStates, alphabet, transitionTable, br, bw);
    }
}
