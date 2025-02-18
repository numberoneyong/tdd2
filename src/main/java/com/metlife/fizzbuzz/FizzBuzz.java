package com.metlife.fizzbuzz;

public class FizzBuzz {
    public String fizzBuzz(int number) {
        if (number % 3 == 0 && number % 5 == 0) return "FizzBuzz";
        if (number % 3 == 0) return "Fizz";
        if (number % 5 == 0) return "Buzz";

        return String.valueOf(number);
    }

    public String display() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 100; i++) {
            sb.append(fizzBuzz(i));
            sb.append("\n");
        }

        return sb.toString();
    }
}
