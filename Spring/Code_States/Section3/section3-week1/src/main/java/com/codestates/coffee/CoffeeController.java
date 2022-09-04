package com.codestates.coffee;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/coffees", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CoffeeController {

    @PostMapping
    public String postCoffee(@RequestParam("engName") String engName,
                             @RequestParam("korName") String korName,
                             @RequestParam("price") int price) {

        System.out.println("# engName: " + engName);
        System.out.println("# korName: " + korName);
        System.out.println("# price: " + price);

        String response =
                "{\"" +
                "engName\":\"" + engName + "\"," +
                "\"korName\":\"" + korName + "\",\"" +
                "price\":\"" + price +
                "\"}";

        return response;
    }

    @GetMapping("/{coffee-id}")
    public String getCoffee(@PathVariable("coffee-id") long coffeeId) {

        System.out.println("coffee-id :" + coffeeId);

        return null;
    }

    @GetMapping
    public String getCoffees(){
        System.out.println("# get Coffees");

        return null;
    }




}
