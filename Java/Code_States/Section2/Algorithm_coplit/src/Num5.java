import java.util.*;

public class Num5 {
    public static void main(String[] args){

        ArrayList<String[]> output = rockPaperScissors(2);

        for(int i = 0; i < output.size(); i++){
            System.out.print("[");
            for(int j = 0; j < output.get(i).length; j++){
                System.out.print(output.get(i)[j]);
                System.out.print(", ");
            }
            System.out.println("]");
        }


    }

    public static ArrayList<String[]> rockPaperScissors(int rounds) {
        // TODO:
        ArrayList<String[]> result = new ArrayList<>();

        ArrayList<String[]> newArrayList = new ArrayList<>();
        result = permutation(newArrayList, new String[]{}, rounds);

        return result;
    }

    public static ArrayList<String[]> permutation (ArrayList<String[]> arraylist, String[] arr, int leftRounds){

        if(leftRounds == 0) {
            arraylist.add(arr);
            return arraylist;
        }

        String[] arrayRSP = new String[]{"rock", "paper", "scissors"};

        for(int i = 0; i < arrayRSP.length; i++){
            String[] newArr = Arrays.copyOf(arr, arr.length+1);
            newArr[arr.length] = arrayRSP[i];
            arraylist = permutation(arraylist, newArr, leftRounds-1);
        }

        return arraylist;
    }



}
