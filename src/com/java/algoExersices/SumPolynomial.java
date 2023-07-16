package com.java.algoExersices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumPolynomial {
    public static void main(String[] args) {
        int firstExponent;
        int secondExponent;
        int[] firstArray;
        int[] secondArray;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            firstExponent = Integer.parseInt(reader.readLine());
            firstArray = getPolynomial(firstExponent, reader.readLine());
            secondExponent = Integer.parseInt(reader.readLine());
            secondArray = getPolynomial(secondExponent, reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (firstExponent >= secondExponent) {
            getResultOutput(firstExponent, sumPolynomial(firstExponent, secondExponent, firstArray, secondArray));
        } else {
            getResultOutput(secondExponent, sumPolynomial(secondExponent, firstExponent, secondArray, firstArray));
        }
    }

    private static void getResultOutput(int biggerExponent, int[] result) {
        System.out.println(biggerExponent);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] sumPolynomial(int biggerExponent, int smallerExponent, int[] biggerArray, int[] smallerArray) {
        for (int i = 0; i < smallerArray.length; i++) {
            biggerArray[biggerExponent - smallerExponent + i] += smallerArray[i];
        }
        return biggerArray;
    }

    private static int[] getPolynomial(int exponent, String input) {
        int[] firstArray;
        firstArray = new int[exponent + 1];
        String[] cut = input.split(" ");
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = Integer.parseInt(cut[i]);
        }
        return firstArray;
    }
}
