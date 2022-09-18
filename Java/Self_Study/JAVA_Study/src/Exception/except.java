package Exception;

public class except {
    public static void main(String[] args){

        System.out.println(1);
        int[] scores = {10, 20, 30};
        try{
            System.out.println(2);
            System.out.println(scores[3]);
            System.out.println(3);
            System.out.println(2 / 0);
            System.out.println(4);
        } catch (ArithmeticException e){
            System.out.println("잘못된 계산이네요");
        } catch (Exception e){
            System.out.println("무언가가 잘못되었습니다");
        }
        System.out.println(5);

    }
}
