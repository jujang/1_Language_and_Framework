package com.codestates.order.dto;

import com.codestates.coffee.dto.CoffeeResponseDto;
import com.codestates.order.entity.Order;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderResponseDto {
    private long orderId;
    private long memberId;
    private Order.OrderStatus orderStatus;
    private List<CoffeeResponseDto> orderCoffees;
    private LocalDateTime createdAt;
}
