import core.BasicProblem;
import core.Constants;
import nfa.Problem10;
import nfa.Problem8;
import nfa.Problem9;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(Constants.INPUT_FILE));
        BufferedWriter bw = new BufferedWriter(new FileWriter(Constants.OUTPUT_FILE));
        String line;
        BasicProblem currentProblem;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            String answer = "";
            if (line.equals(Constants.ONE)) {

            } else if (line.equals(Constants.TWO)) {
            } else if (line.equals(Constants.THREE)) {
            } else if (line.equals(Constants.FOUR)) {
            } else if (line.equals(Constants.FIVE)) {
            } else if (line.equals(Constants.SIX)) {
            } else if (line.equals(Constants.SEVEN)) {
            } else if (line.equals(Constants.EIGHT)) {
                currentProblem = new Problem8(br,bw);
            } else if (line.equals(Constants.NINE)) {
                currentProblem = new Problem9(br,bw);
            } else if (line.equals(Constants.TEN)) {
               currentProblem = new Problem10(br,bw);
            }
        }
        br.close();
        bw.close();
    }
}