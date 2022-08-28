package com.codestates.chapter2.di;

import java.util.*;

public class CafeClient {
    public static void main(String[] args){
        MenuService menuService = new MenuServiceStub();
        MenuController controller = new MenuController(menuService);
        List<Menu> menuList = controller.getMenus();
    }
}
