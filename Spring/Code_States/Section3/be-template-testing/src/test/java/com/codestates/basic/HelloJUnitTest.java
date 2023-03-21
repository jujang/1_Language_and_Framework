package com.codestates.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class HelloJUnitTest {
    @DisplayName("Hello JUnit Test1")
    @Test
    public void assertionTest1() {
        String expected = "Hello, World";
        String actual = "Hello, World";

        assertEquals(expected, actual);
    }

    @DisplayName("Hello JUnit Test2")
    @Test
    public void assertionTest2() {
        String expected = "Hello, World";
        String actual = "Hello, JUnit";

        assertNotEquals(expected, actual);
    }
}
