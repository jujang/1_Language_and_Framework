public class Main {
    public static void main(String[] args) {
        System.out.println(calculateElectric(99) + "원");
        System.out.println(calculateElectric(150) + "원");
        System.out.println(calculateElectric(250) + "원");
        System.out.println(calculateElectric(301) + "원");
        System.out.println(calculateElectric(450) + "원");
        System.out.println(calculateElectric(510) + "원");
    }

    public static int calculateElectric(int usage){
        double sum = 0;

        // ~100kWh까지
        if(usage <= 100){
            return (int)(usage*60.7);
        } else {
            sum += (100*60.7);
            usage -= 100;
        }

        // ~200kWh까지
        if(usage <= 100){
            return (int)(sum + (usage*125.9));
        } else {
            sum += (100*125.9);
            usage -= 100;
        }

        // ~300kWh까지
        if(usage <= 100){
            return (int)(sum + (usage*187.9));
        } else {
            sum += (100*187.9);
            usage -= 100;
        }

        // ~400kWh까지
        if(usage <= 100){
            return (int)(sum + (usage*280.6));
        } else {
            sum += (100*280.6);
            usage -= 100;
        }

        // ~500kWh까지
        if(usage <= 100){
            return (int)(sum + (usage*417.7));
        } else {
            sum += (100*417.7);
            usage -= 100;
        }

        // 500kWh~
        return (int)(sum + (usage*670.6));

    }

}