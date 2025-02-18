package com.metlife.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;
    private ByteArrayOutputStream byteArrayOutputStream;


    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    void 삼의_배수는_Fizz_가_출력된다() {
        assertEquals("Fizz", fizzBuzz(3));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20})
    void 오의_배수는_Buzz_가_출력된다(int number) {
        assertEquals("Buzz", fizzBuzz(number));
    }

    @Test
    void 십오의_배수는_FizzBuzz_가_출력된다() {
        assertEquals("FizzBuzz", fizzBuzz(45));
    }

    @Test
    void fizzBuzz알고리즘이_적용된_값을_일부터_100까지_출력할_수_있다() {
        String result = fizzBuzz.display();
        System.out.println(result);
        String[] split = byteArrayOutputStream.toString().trim().split("\n");

        assertEquals(100, split.length);
        assertEquals("1", split[0]);
        assertEquals("Fizz", split[2]);
        assertEquals("Buzz", split[99]);
        assertEquals("FizzBuzz", split[29]);
    }

    private String fizzBuzz(int number) {
        return fizzBuzz.fizzBuzz(number);
    }
}
