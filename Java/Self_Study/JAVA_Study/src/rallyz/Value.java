package rallyz;

public class Value {

    private String str;

    public Value(String str){
        this.str = str;
    }

    public String getValue(){
        return this.str;
    }

    public boolean equals(Object obj){

        if(obj instanceof Value && this.getValue().equals(((Value)obj).getValue())) {
            return true;
        }
        return false;
    }

}
