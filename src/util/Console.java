package util;

import java.util.Scanner;

public class Console {
    private static Scanner sc = new Scanner(System.in);

    public static void print(String s){
        System.out.print(s);
    }
    public static void println(){
        System.out.println();
    }
    public static void println(String s){
        System.out.println(s);
    }

    public static int getInt(String prompt){
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                println("Error! Invalid integer. Try again.");
            }
            sc.nextLine(); // discard any other data entered on the line
        }
        return i;
    }
    public static int getInt(String prompt, int min, int max){
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            i = getInt(prompt);
            if (i <= min) {
                println("Error! Number must be greater than " + min + ".");
            } else if (i >= max) {
                println("Error! Number must be less than " + max + ".");
            } else {
                isValid = true;
            }
        }
        return i;
    }

    public static double getDouble(String prompt){
        double d = 0;
        boolean isValid = false;
        while (!isValid) {
            print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            } else {
                println("Error! Invalid number. Try again.");
            }
            sc.nextLine(); // discard any other data entered on the line
        }
        return d;
    }
    public static double getDouble(String prompt, double min, double max){
        double d = 0;
        boolean isValid = false;
        while (!isValid) {
            d = getDouble(prompt);
            if (d <= min) {
                println("Error! Number must be greater than " + min + ".");
            } else if (d >= max) {
                println("Error! Number must be less than " + max + ".");
            } else {
                isValid = true;
            }
        }
        return d;
    }

    public static String getString(String prompt){
        String s = "";
        boolean isValid = false;
        while (isValid == false) {
            print(prompt);
            s = sc.nextLine();
            if (s.equals("")) {
                println("Error! This entry is required. Try again.");
            } else {
                isValid = true;
            }
        }
        return s;
    }
    public static String getString(String prompt, String s1, String s2){
        String s = "";
        boolean isValid = false;
        while (isValid == false) {
            s = getString(prompt);
            if (!s.equalsIgnoreCase(s1) && !s.equalsIgnoreCase(s2)) {
                println("Error! Entry must be '" + s1 + "' or '" + s2 + "'. Try again.");
            } else {
                isValid = true;
            }
        }
        return s;
    }
}