package com.codestates.coffee;

import com.codestates.member.NotSpace;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Optional;

public class CoffeePatchDto {

    private long coffeeId;

    @NotSpace
    private String korName;

    @Pattern(regexp = "^([a-zA-Z])(\\s?[a-zA-Z])*$")
    private String engName;


//    @Range(min=100, max=50000)
//    int price;
    private Optional<@Range(min= 100, max= 50000) Integer> price = Optional.empty();


    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getKorName() {
        return korName;
    }

    public void setKorName(String korName) {
        this.korName = korName;
    }

//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }

    public Optional<Integer> getPrice() {
    return price;
}

    public void setPrice(Optional<Integer> price) {
        this.price = price;
    }


    public long getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(long coffeeId) {
        this.coffeeId = coffeeId;
    }
}
