//package com.example.cmarket;
//
//import com.example.cmarket.Order.OrderService;
//import com.example.cmarket.Order.OrderServiceImpl;
//import com.example.cmarket.discount.CurrentDiscountInfo;
//import com.example.cmarket.discount.DiscountInfo;
//import com.example.cmarket.user.UserRepository;
//import com.example.cmarket.user.UserRepositoryImpl;
//import com.example.cmarket.user.UserService;
//import com.example.cmarket.user.UserServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.FilterType;
//
//@Configuration
//@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
//public class AutoAppConfig {
//
//    public UserService userService() {
//        return new UserServiceImpl(UserRepository());
//    }
//
//    public UserRepository UserRepository() {
//        return new UserRepositoryImpl();
//    }
//
//    public OrderService orderService() {
//        return new OrderServiceImpl(UserRepository(), discountInfo());
//    }
//
//    public DiscountInfo discountInfo() {
//        return new CurrentDiscountInfo();
//    }
//
//}
