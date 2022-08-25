package Interface_Class;

public class interface_class {
    public static void main(String[] args){
        MenuService menuService = new MenuServiceStub();
//        System.out.println(menuService.a);
//        menuService.print();
//        System.out.println(menuService.getMenuList());
//        MenuServiceStub menuServiceStub = new MenuServiceStub();
//        System.out.println(menuServiceStub.a);
//        menuServiceStub.print();
//        System.out.println(menuServiceStub.getMenuList());

        MenuController controller = new MenuController(menuService);
    }
}
