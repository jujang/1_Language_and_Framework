package com.codestates.chapter2.di;

import java.util.*;

public class MenuServiceStub implements MenuService{
    @Override
    public List<Menu> getMenuList() {
        return List.of(
                new Menu(1, "아메리카노", 2500),
                new Menu(2, "카라멜 마끼아또", 5000),
                new Menu(3, "바닐라 라떼", 4000)
        );
    }

}
