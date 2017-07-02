package com.codeclan.example.fruitmachine;

/**
 * Created by user on 02/07/2017.
 */

public class TextUtils {
    public static int[] parseStringToIntArray(String input) {
        String inputStringArray[] = input.split(" ");

        int inputArray[] = new int[inputStringArray.length];

        for(int i=0; i<inputStringArray.length; i++){
            inputArray[i] = Integer.parseInt(inputStringArray[i]) - 1;
        }

        return inputArray;
    }
}
