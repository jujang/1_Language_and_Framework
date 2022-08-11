package SamePackage;
import OtherPackage.*;

class SameClassChecker{
    public SameClassChecker(){

        this._public();
        this._protected();
        this._default();
        this._private();

    }
    public void _public() {
        System.out.println("public");
    }
    protected void _protected() {
        System.out.println("protected");
    }
    void _default() {
        System.out.println("default");
    }
    private void _private() {
        System.out.println("private");
    }
}

class SamePackageChecker extends Same{
    public SamePackageChecker(){

        Same same = new Same();
        same._public();
        same._protected();
        same._default();
//        same._private(); // error

        this._public();
        this._protected();
        this._default();
//        this._private(); // error

    }
}

class OtherPackageChecker extends Other{
    public OtherPackageChecker(){

        Other other = new Other();
        other._public();
//        other._protected(); // error
//        other._default(); // error
//        other._private(); // error

        this._public();
        this._protected();
//        this._default(); // error
//        this._private(); // error

    }
}

public class Checker {
    public static void main(String[] args){

    }
}
