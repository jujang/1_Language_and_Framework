package com.codestates.coffee.service;

import com.codestates.coffee.entity.Coffee;
import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.order.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoffeeService {
    public Coffee createCoffee(Coffee coffee) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    public Coffee updateCoffee(Coffee coffee) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    public Coffee findCoffee(long coffeeId) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    public List<Coffee> findCoffees() {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    public void deleteCoffee(long coffeeId) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    // 주문에 해당하는 커피 정보 조회
    public List<Coffee> findOrderedCoffees(Order order) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }
}
