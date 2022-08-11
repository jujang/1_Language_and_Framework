import java.util.*;

public class Num6 {
    public static void main(String args[]){

        ArrayList<String[]> output = rockPaperScissors(5);
        System.out.println(output);

    }

    public static ArrayList<String[]> rockPaperScissors(int rounds) {
        // TODO:
        ArrayList<String[]> result = new ArrayList<>();
        String[] arrayRSP = new String[]{"rock", "paper", "scissors"};

        int cnt = 0;
        while(cnt < rounds) {
            for(int i = 0; i < 3; i++){
                String[] arrayContainer = new String[]{arrayRSP[i]};
                if(!result.contains(arrayContainer)) result.add(arrayContainer);


            }
        }


        return result;
    }
}
