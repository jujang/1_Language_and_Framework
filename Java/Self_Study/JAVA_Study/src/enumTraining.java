public class enumTraining {
    public static void main(String[] args){

        Seasons aaa = Seasons.SUMMER;
        System.out.println(aaa.ordinal());
        switch(aaa){
            case SUMMER:
                System.out.println("a");
                break;
            default :
                System.out.println("z");
                break;
        }

    }
}

enum Seasons{
    SPRING, // 0?
    SUMMER, // 1?
    FALL,  // 2?
    WINTER // 3?
}