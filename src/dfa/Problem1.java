import static java.util.Map.entry;
import java.io.*;
import java.util.Map;

public class Problem1 {
    public Problem1(BufferedReader br, BufferedWriter bw) {
        int[] states = {0, 1}; 
        int startState = 0;
        int[] finalStates = {1}; 
        char[] alphabet = {'a', 'b'};
        Map<Integer, int[]> transitionTable = Map.ofEntries(
            entry(0, new int[]{1, 0}),
            entry(1, new int[]{0, 1})
        );

        DFA dfa = new DFA();
        dfa.runDFA(states, startState, finalStates, alphabet, transitionTable, br, bw);
    }
}
