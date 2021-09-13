package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        System.out.println("Velkommen til den underlegende krypteringsmaskine!");
        System.out.println("Tast d for at encode eller tast e for at decode.");

        String answer = in.nextLine();

        if (answer.equals("d")){
            System.out.print("Du har valgt at encode - indtast en tekst: ");
            String encodeText = in.nextLine();
            System.out.print("Encoded tekst: ");
            printIntArray(encodeText);
        }
        if (answer.equals("e")) {
            System.out.print("Du har valgt at decode - indtast nogle tal: ");
            String decodeText = in.nextLine();
            System.out.print("Decoded tekst: ");
            printStringArray(decodeText);
        }

    }

    public static int letterToInt(String letter) {
        String[] alphabet = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
                "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "Æ", "Ø", "Å"};
        String let = letter.toUpperCase();
        int number = Arrays.binarySearch(alphabet, let);
        if (number == -28) {
            number = 29;
        }

        return number;
    }

    public static String textToIntArray(String text) {
        int[] list = new int[text.length()];

        for (int i = 0; i < text.length(); i++) {
             int number = letterToInt(text.substring(i, i+1));
             list[i] = number;
        }

        return Arrays.toString(list);
    }

    public static void printIntArray(String text) {
        System.out.println(textToIntArray(text));
    }

    // kodeinspiration for de næste metoder:
    // https://www.geeksforgeeks.org/java-program-to-convert-string-to-integer-array/

    public static String[] stringToArray(String numbers) {
        String[] stringArray = numbers.replaceAll("\\{", "").replaceAll("}", "").replaceAll(" ", "")
                .replaceAll("\\[", "").replaceAll("]", "").split(",");
        return stringArray;
    }

    public static int[] stringArrayToIntArray(String numbers) {
        String[] stringArray = stringToArray(numbers);

        int[] intArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.valueOf(stringArray[i]);
        }
        return intArray;
    }

    public static String[] intArrayToString(String numbers) {
        int[] integerList = stringArrayToIntArray(numbers);
        String[] alphabet = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
                "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "Æ", "Ø", "Å"};
        String[] finalText = new String[integerList.length];

        for (int i = 0; i < integerList.length; i++) {
            finalText[i] = alphabet[integerList[i]];
        }
        return finalText;
    }

    public static void printStringArray(String numbers) {
        System.out.println(Arrays.toString(intArrayToString(numbers)));
    }
}
