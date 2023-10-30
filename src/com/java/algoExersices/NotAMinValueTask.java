package com.java.algoExersices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NotAMinValueTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] lengthAndCount = inputToIntDataArray(reader);
        int[] intSequence = inputToIntDataArray(reader);
        for (int i = 0; i < lengthAndCount[1]; i++) {
            int[] coords = inputToIntDataArray(reader);
            findAnyBesideMin(coords[0], coords[1], intSequence);
        }
    }

    private static int[] inputToIntDataArray(BufferedReader reader) throws IOException {
        String[] input = reader.readLine().split(" ");
        int[] data = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            data[i] = Integer.parseInt(input[i]);
        }
        return data;
    }

    private static void findAnyBesideMin(int start, int end, int[] intSequence) {
        while (start < end) {
           if(intSequence[start]!=intSequence[end]){
               System.out.println(Math.max(intSequence[start],intSequence[end]));
               return;
           }
           start++;
        }
        System.out.println("NOT FOUND");
    }
}
