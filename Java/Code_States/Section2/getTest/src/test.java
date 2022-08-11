import java.util.*;

public class test {
    public static void main(String args[]) {
        Integer[] boxes = new Integer[]{5, 1, 4, 6};
        int output = paveBox(boxes);
        System.out.println(output); // 3
    }

    public static int paveBox(Integer[] boxes) {

        int count = 0;
        ArrayList<Integer> result = new ArrayList<>();
        List<Integer> arr = new ArrayList<Integer>(Arrays.asList(boxes));

        while(arr.size() > 0){
            for(int i = 0; i < arr.size(); i++){
                if(arr.get(0) >= arr.get(i)){
                    count ++;
                }
                else{
                    arr = Arrays.copyOfRange(arr, i, arr.size());
                    result.add(count);
                    count = 0;
                    break;
                }
            }
        }
        return Collections.max(result);
    }
}
