package com.codestates.order.mapper;

import com.codestates.coffee.dto.CoffeeResponseDto;
import com.codestates.coffee.entity.Coffee;
import com.codestates.coffee.entity.CoffeeRef;
import com.codestates.order.entity.Order;
import com.codestates.order.dto.OrderPostDto;
import com.codestates.order.dto.OrderResponseDto;
import org.mapstruct.Mapper;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    default Order orderPostDtoToOrder(OrderPostDto orderPostDto) {
        Order order = new Order();
        order.setMemberId(new AggregateReference.IdOnlyAggregateReference(
                                                        orderPostDto.getMemberId()));
        Set<CoffeeRef> orderCoffees = orderPostDto.getOrderCoffees()
                .stream()
                .map(orderCoffeeDto -> new CoffeeRef(orderCoffeeDto.getCoffeeId(),
                        orderCoffeeDto.getQuantity()))
                .collect(Collectors.toSet());
        order.setOrderCoffees(orderCoffees);
        order.setCreatedAt(LocalDateTime.now());
        return order;
    }

    default OrderResponseDto orderToOrderResponseDto(Order order,
                                                     List<Coffee> coffees) {
        List<CoffeeResponseDto> orderCoffees =
                coffees
                        .stream()
                        .map(coffee ->
                                new CoffeeResponseDto(coffee.getCoffeeId(),
                                        coffee.getKorName(),
                                        coffee.getEngName(),
                                        coffee.getPrice()))
                        .collect(Collectors.toList());
        long memberId = order.getMemberId().getId();

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderCoffees(orderCoffees);
        orderResponseDto.setMemberId(memberId);
        orderResponseDto.setCreatedAt(order.getCreatedAt());
        orderResponseDto.setOrderId(order.getOrderId());
        orderResponseDto.setOrderStatus(order.getOrderStatus());

        // TODO 주문에 대한 더 자세한 정보로의 변환은 요구 사항에 따라 다를 수 있습니다.

        return orderResponseDto;
    }
}
