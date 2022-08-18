public class generic {
    public static void main(String[] args){

        Basket<Integer> hoho = new Basket<Integer>(1);

    }
}

class Basket<T> {
    private T item;
    public Basket(T item){
        this.item = item;
    }
    public T getItem(){
        return item;
    }
    public void setItem(T item){
        this.item = item;
    }
}
