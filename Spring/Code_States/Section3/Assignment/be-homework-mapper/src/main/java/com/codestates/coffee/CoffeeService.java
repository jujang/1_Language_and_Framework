package com.codestates.coffee;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {
    public static Coffee createCoffee(Coffee coffee){
//        Coffee createdCoffee = coffee;
        return coffee;
    }
    public static Coffee updateCoffee(Coffee coffee){
//        Coffee updatedCoffee = coffee;
        return coffee;
    }
    public static Coffee findCoffee(long coffeeId){
        return new Coffee(coffeeId, "아메리카노", "Americano", 2500);
    }
    public static List<Coffee> findCoffees(){
        List<Coffee> coffees = List.of(
                new Coffee(1L, "아메리카노", "Americano", 2500),
                new Coffee(2L, "카라멜 라떼", "Caramel Latte", 5000)
        );
        return coffees;
    }
    public static void deleteCoffee(long coffeeId){

    }

}
