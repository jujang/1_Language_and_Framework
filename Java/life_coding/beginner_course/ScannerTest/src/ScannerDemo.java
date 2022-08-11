import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class ScannerDemo {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            System.out.println(sc.next());
//            System.out.println(50);
//        }
//        sc.close();
//        System.out.println(10);
//    }
//}

public class ScannerDemo {
    public static void main(String[] args) {
        try{
//            File file = new File("C:\\Workspace\\1_Language&Framwork\\Java\\life_coding\\beginner_course\\ScannerTest\\src\\test.txt");
            File file = new File("src\\test.txt");
            Scanner sc = new Scanner(file);
            while(sc.hasNext()){
                System.out.println(sc.next());
                System.out.println(50);
            }
            sc.close();
            System.out.println(10);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}