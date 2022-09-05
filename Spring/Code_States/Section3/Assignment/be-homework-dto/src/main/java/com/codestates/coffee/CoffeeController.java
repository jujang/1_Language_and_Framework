package com.codestates.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/coffees")
public class CoffeeController {
    // 1. DTO 클래스 및 유효성 검증을 적용하세요.
    @PostMapping
    public ResponseEntity postCoffee(@RequestParam("korName") String korName,
                                     @RequestParam("engName") String engName,
                                     @RequestParam("price") int price) {
        Map<String, Object> map = new HashMap<>();
        map.put("korName", korName);
        map.put("engName", engName);
        map.put("price", price);


        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    // 2. DTO 클래스 및 유효성 검증을 적용하세요.
    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") long coffeeId,
                                      @RequestParam("korName") String korName,
                                      @RequestParam("price") int price) {
        Map<String, Object> body = new HashMap<>();
        body.put("coffeeId", coffeeId);
        body.put("korName", korName);
        body.put("engName", "Vanilla Latte");
        body.put("price", price);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {
        System.out.println("# coffeeId: " + coffeeId);

        // not implementation

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees() {
        System.out.println("# get Coffees");

        // not implementation

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") long coffeeId) {
        // No need business logic

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
