import java.util.*;

public class test {
    public static void main(String args[]){

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.isEmpty());
        System.out.println(stack.empty());
        System.out.println(stack);


//        Queue<Integer> queue = new Queue<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue);

        queue.poll();
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        queue.clear();
        System.out.println(queue);



    }
}
