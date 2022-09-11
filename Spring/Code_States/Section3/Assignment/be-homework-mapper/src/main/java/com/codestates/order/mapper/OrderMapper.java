package com.codestates.order.mapper;

import com.codestates.order.Order;
import com.codestates.order.OrderPostDto;
import com.codestates.order.OrderResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order orderPostDtoToOrder(OrderPostDto orderPostDto);
    OrderResponseDto orderToOrderResponseDto(Order order);
}
