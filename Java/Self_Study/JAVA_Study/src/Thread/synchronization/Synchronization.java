package Thread.synchronization;

public class Synchronization {
    public static void main(String args[]){
        Runnable r = new RunnableExample();
        new Thread(r).start();
        new Thread(r).start();
    }
}



