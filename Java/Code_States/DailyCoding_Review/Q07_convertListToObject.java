import java.util.*;

public class Q07_convertListToObject {
    public static void main(String[] args){

        String[][] arr = {
                {"make", "Ford"},
                {"model", "Mustang"},
                {"year", "1964"},
                {"make", "Bill"}
        };

        HashMap<String, String> output = convertListToObject(arr);
        System.out.println(output);
    }

    public static HashMap<String, String> convertListToObject(String[][] arr){

        HashMap<String, String> map = new HashMap<>();
        if(arr.length == 0 || arr[0].length == 0) return map;

        for(int i = 0; i < arr.length; i++){
            if(!map.containsKey(arr[i][0])){
                map.put(arr[i][0], arr[i][1]);
            }
        }

        return map;
    }

}
