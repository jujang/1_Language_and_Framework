package Interface_Class;

import java.util.*;

public class MenuController {
    private MenuService menuService;

    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }
    public List<String> getMenu(){
        return menuService.getMenuList();
    }

}
