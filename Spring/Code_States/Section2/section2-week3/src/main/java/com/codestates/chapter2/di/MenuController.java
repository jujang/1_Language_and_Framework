package com.codestates.chapter2.di;

import java.util.*;

public class MenuController {
    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }
    public List<Menu> getMenus(){
        return menuService.getMenuList();
    }
}
