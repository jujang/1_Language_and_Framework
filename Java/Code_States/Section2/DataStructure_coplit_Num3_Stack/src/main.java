import java.util.*;

public class main {
    public static void main(String args[]) {

        String[] actions = new String[]{"B", "C", "-1", "D", "A", "-1", "1", "-1", "-1"};
        String start = "A";
        ArrayList<Stack> output = browserStack(actions, start);

        System.out.println(output); // [["A"], ["B"], ["A", "D"]]

    }
    public static ArrayList<Stack> browserStack(String[] actions, String start) {
        Stack<String> prevStack = new Stack<>();
        Stack<String> nextStack = new Stack<>();
        Stack<String> current = new Stack<>();
        ArrayList<Stack> result = new ArrayList<>();

        // 문제가 이상함.. false가 어떻게 반환될 수 있지...;;

        current.push(start);
        for(int i = 0; i < actions.length; i++){
            if(Character.isUpperCase(actions[i].charAt(0))) {
                prevStack.push(current.pop());
                current.push(actions[i]);
                nextStack.clear();
            } else if(actions[i].equals("-1")){
                if(prevStack.size() == 0) continue;
                nextStack.push(current.pop());
                current.push(prevStack.pop());
            } else if(actions[i].equals("1")){
                if(nextStack.size() == 0) continue;
                prevStack.push(current.pop());
                current.push(nextStack.pop());
            } else continue;
        }

        result.add(prevStack);
        result.add(current);
        result.add(nextStack);
        return result;
    }
}
