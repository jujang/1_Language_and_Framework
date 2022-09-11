package com.codestates.order;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    public Order createOrder(Order order) {
        // TODO should business logic

        // TODO order 객체는 나중에 DB에 저장 후, 되돌려 받는 것으로 변경 필요.
        return order;
    }

    public Order findOrder(long orderId) {
        // TODO should business logic

        // TODO order 객체는 나중에 DB에서 조회 하는 것으로 변경 필요.
        return new Order(1L, 1L);
    }

    // 주문 수정 메서드는 사용하지 않습니다.

    public List<Order> findOrders() {
        // TODO should business logic

        // TODO order 객체는 나중에 DB에서 조회하는 것으로 변경 필요.
        return List.of(new Order(1L, 1L),
                new Order(2L, 2L));
    }

    public void cancelOrder() {
        // TODO should business logic
    }
}
