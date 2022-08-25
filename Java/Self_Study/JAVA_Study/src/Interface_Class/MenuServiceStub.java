package Interface_Class;

import java.util.*;

public class MenuServiceStub implements MenuService{

    int a = 1;
    public List<String> getMenuList(){
        return List.of(
                new String("1st"),
                new String("2nd"),
                new String("3rd")
        );
    }

//    public void print(){
//        System.out.println("11");
//    }
}
