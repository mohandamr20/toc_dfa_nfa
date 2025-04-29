public class Problem5
{
 int[] states = {0, 1, 2};
 int startState = 0;
 int[] finalState = {0};
 char[] alphabet = {'a', 'b'};
 public Map<Integer, int[]> transitionTable = Map.ofEntries(
 entry(0, new int[]{1, 0}),
 entry(1, new int[]{0, 2}),
 entry(2, new int[]{2, 2})
 );
 DFA dfa = new DFA(states,startState,finalState,alphabet,transitionTable);
 public Problem1 (BufferedReader br, BufferedWriter bw)
 {
 dfa.solveProblem(br,bw);
 }
}
