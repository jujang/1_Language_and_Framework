package com.codestates.coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@AllArgsConstructor
@Table("ORDER_COFFEE")
public class CoffeeRef {
    private long coffeeId;
    private int quantity;
}
