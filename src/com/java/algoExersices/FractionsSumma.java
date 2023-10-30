package com.java.algoExersices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FractionsSumma {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int[] data = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            data[i] = Integer.parseInt(input[i]);
        }
        int delimiter;
        int dividend;
        if (data[1] != data[3]) {
            delimiter = data[1] * data[3];
            dividend = (data[0] * data[3]) + (data[2] * data[1]);
        } else {
            delimiter = data[1];
            dividend = data[0] + data[2];
        }
        int min = Math.min(delimiter, dividend);
        for (int i = 2; i <= min; i++) {
            while (dividend % i == 0 && delimiter % i == 0) {
                dividend = dividend / i;
                delimiter = delimiter / i;
            }
        }
        System.out.println(dividend + " " + delimiter);
    }
}
