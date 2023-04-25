package rallyz;

public class Question3 {

    public static void main(String[] args){

        Value value1 = new Value("kkk");
        Value value2 = new Value("kkk");


        System.out.println(value1 == value2);
        // ==은 primitive 타입에 대해 값 비교, 나머지는 주소 비교
        // 그러므로, value1과 value2의 주소값은 다르므로 false

        System.out.println(value1.equals(value2));
        // instanceOf는 괜찮음
        // 그러나, string간의 비교에서 false 주소 비교를 하기 때문에 false

        System.out.println(value1.equals(value2.toString()));
        // toString에 의해 객체의 타입이 string이 되므로
        // override된 equals에서는 instanceOf에 의해 false

        System.out.println(value1.toString() == value2.toString());
        // 첫번째 이유에 의해서 주소 비교
        // 그러므로 false

        System.out.println(value1.toString().equals(value2.toString()));
        // String 간의 equasl는 값 자체 비교 (나머지는 값 자체비교가 아닌가...??? 확인해 볼 것)
        // 그러므로 true

        System.out.println(value1.getValue() == value2.getValue());

    }

}
