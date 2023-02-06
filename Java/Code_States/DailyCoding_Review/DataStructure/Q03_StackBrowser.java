package DataStructure;
import java.util.*;

public class Q03_StackBrowser {
    public static ArrayList<Stack> browserStack(String[] actions, String start) {
        Stack<String> prevStack = new Stack<>();
        Stack<String> nextStack = new Stack<>();
        Stack<String> current = new Stack<>();
        ArrayList<Stack> result = new ArrayList<>();

        // TODO:
        current.add(start);

        for(String page : actions){
            if(page.equals("-1")){
                if(prevStack.size() != 0){
                    nextStack.add(current.pop());
                    current.add(prevStack.pop());
                }
            }
            else if(page.equals("1")){
                if(nextStack.size() != 0){
                    prevStack.add(current.pop());
                    current.add(nextStack.pop());
                }
            } else {
                prevStack.add(current.pop());
                current.add(page);
                nextStack.clear();
            }
        }

        result.add(prevStack);
        result.add(current);
        result.add(nextStack);
        return result;
    }

    public static void main(String[] args){
        String[] actions = new String[]{"B", "C", "-1", "D", "A", "-1", "1", "-1", "-1"};
        String start = "A";
        ArrayList<Stack> output = browserStack(actions, start);

        System.out.println(output); // [["A"], ["B"], ["A", "D"]]

        String[] actions2 = new String[]{"B", "-1", "B", "A", "C", "-1", "-1", "D", "-1", "1", "E", "-1", "-1", "1"};
        String start2 = "A";
        ArrayList<Stack> output2 = browserStack(actions2, start2);

        System.out.println(output2); // [["A", "B"], ["D"], ["E"]]
    }
}
