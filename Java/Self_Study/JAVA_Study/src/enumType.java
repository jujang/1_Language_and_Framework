public class enumType {

    public static void main(String[] args) {
        Fruit type = Fruit.APPLE;
        switch(type){
            case APPLE:
                System.out.println(57+" kcal, "+Fruit.APPLE.getColor());
                break;
            case PEACH:
                System.out.println(34+" kcal, "+Fruit.PEACH.getColor());
                break;
            case BANANA:
                System.out.println(93+" kcal, "+Fruit.BANANA.getColor());
                break;
        }
    }

}

enum Fruit{
    APPLE("red"), PEACH("pink"), BANANA("yellow");
    private String color;
    Fruit(String color){
        System.out.println("Call Constructor "+this);
        this.color = color;
    }
    String getColor(){
        return this.color;
    }
}

enum Company{
    GOOGLE, APPLE, ORACLE;
}