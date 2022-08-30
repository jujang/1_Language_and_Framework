package com.example.cmarket;

import com.example.cmarket.Order.OrderService;
import com.example.cmarket.Order.OrderServiceImpl;
import com.example.cmarket.discount.CurrentDiscountInfo;
import com.example.cmarket.discount.DiscountInfo;
import com.example.cmarket.user.UserRepository;
import com.example.cmarket.user.UserRepositoryImpl;
import com.example.cmarket.user.UserService;
import com.example.cmarket.user.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {
//    @Bean
//    public UserService userService() {
//        return new UserServiceImpl(UserRepository());
//    }
//
//    @Bean
//    public UserRepository UserRepository() {
//        return new UserRepositoryImpl();
//    }
//
//    @Bean
//    public OrderService orderService() {
//        return new OrderServiceImpl(UserRepository(), discountInfo());
//    }
//
//    @Bean
//    public DiscountInfo discountInfo() {
//        return new CurrentDiscountInfo();
//    }
}
