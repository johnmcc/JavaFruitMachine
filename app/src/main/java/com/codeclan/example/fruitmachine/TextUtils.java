package com.codeclan.example.fruitmachine;

/**
 * Created by user on 02/07/2017.
 */

public class TextUtils {
    public static int[] parseStringToIntArray(String input) {
        String inputStringArray[] = input.split(" ");

        int[] inputArray = new int[inputStringArray.length];

        for(int i=0; i<inputStringArray.length; i++){
            // we're doing -1 here as the return array should be zero-indexed
            inputArray[i] = Integer.parseInt(inputStringArray[i]) - 1;
        }

        return inputArray;
    }

    public static String getStars(int number){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<number; i++){
            sb.append("*");
        }
        return sb.toString();
    }
}
