package com.example.cmarket.discount;

import com.example.cmarket.user.User;

public interface DiscountInfo {
    int discount(User user, int price);
}
