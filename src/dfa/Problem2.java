import static java.util.Map.entry;
import java.io.*;
import java.util.Map;

public class Problem2 {
    public Problem2(BufferedReader br, BufferedWriter bw) {
        int[] states = {0, 1, 2, 3}; 
        int startState = 0;
        int[] finalStates = {3};
        char[] alphabet = {'0', '1'};
        Map<Integer, int[]> transitionTable = Map.ofEntries(
            entry(0, new int[]{-1, 1}), 
            entry(1, new int[]{2, 2}),
            entry(2, new int[]{3, 3}),
            entry(3, new int[]{3, 3})
        );

        DFA dfa = new DFA();
        dfa.runDFA(states, startState, finalStates, alphabet, transitionTable, br, bw);
    }
}
