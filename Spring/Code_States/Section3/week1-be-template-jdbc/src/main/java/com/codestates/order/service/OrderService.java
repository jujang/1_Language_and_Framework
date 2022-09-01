package com.codestates.order.service;

import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.order.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    public Order createOrder(Order order) {
        // TODO should business logic

        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    public Order findOrder(long orderId) {
        // TODO should business logic

        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    // TODO 주문 상태 수정 메서드는 JPA 학습에서 추가됩니다.

    public List<Order> findOrders() {
        // TODO should business logic

        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    public void cancelOrder(long orderId) {
        // TODO should business logic

        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }
}
