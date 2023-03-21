package com.codestates.homework;

import com.codestates.exception.BusinessLogicException;
import com.codestates.order.entity.Order;
import com.codestates.order.repository.OrderRepository;
import com.codestates.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.DoesNothing;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
public class OrderServiceHomeworkTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Test
    public void cancelOrderTest() {
        // TODO OrderService의 cancelOrder() 메서드를 테스트하는 테스트 케이스를 여기에 작성하세요.
        // TODO Mockito를 사용해야 합니다. ^^

        // given
        long orderId = 1L;
        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderStatus(Order.OrderStatus.ORDER_CONFIRM);

        Optional<Order> optional = Optional.of(order);
        given(orderRepository.findById(orderId)).willReturn(optional);


        // when & then
        assertThrows(BusinessLogicException.class, () -> orderService.cancelOrder(orderId));

    }


    @Test
    public void cancelOrderNotThrowTest() {
        // TODO OrderService의 cancelOrder() 메서드를 테스트하는 테스트 케이스를 여기에 작성하세요.
        // TODO Mockito를 사용해야 합니다. ^^

        // given
        long orderId = 1L;
        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderStatus(Order.OrderStatus.ORDER_REQUEST);

        Optional<Order> optional = Optional.of(order);
        given(orderRepository.findById(orderId)).willReturn(optional);
        given(orderRepository.save(Mockito.any(Order.class))).willReturn(null);


        // when & then
        assertDoesNotThrow(() -> orderService.cancelOrder(orderId));
    }
}
