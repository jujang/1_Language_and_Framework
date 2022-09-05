package com.codestates.coffee;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CoffeePostDto {

    @NotBlank
    private String korName;
    @NotBlank
    @Pattern(regexp = "^([a-zA-Z])(\\s?[a-zA-Z])*$")
    private String engName;

//    @Min(100)
//    @Max(50000)
    @Range(min = 100, max = 50000)
    private int price;


    public String getKorName() {
        return korName;
    }

    public String getEngName() {
        return engName;
    }

    public int getPrice() {
        return price;
    }
}
