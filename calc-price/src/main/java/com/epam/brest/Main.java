package com.epam.brest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String file_path_distance = "coefficients_distance_km";
        String file_path_weight = "coefficients_weight_kg";

        System.out.println("Distance : ");
        Coefficients distance = new Coefficients(readFormFile(file_path_distance));
        System.out.println("Weight : ");
        Coefficients weight = new Coefficients(readFormFile(file_path_weight));

        Double[] enteredValues = new Double[4];

        Scanner scanner = new Scanner(System.in);
        String inputValue;

        int i = 0;

        do {
            if (i == 0) {
                System.out.println("Please enter distance or Q for exit : ");
            } else if (i == 1) {
                System.out.println("Please enter price per km or Q for exit : ");
            } else if (i == 2) {
                System.out.println("Please enter weight or Q for exit : ");
            } else {
                System.out.println("Please enter price per kg or Q for exit : ");
            }

            inputValue = scanner.next();

            if (!isExitValue(inputValue)) {
                if (isCorrectDoubletValue(inputValue)) {
                    enteredValues[i] = Double.parseDouble(inputValue);
                    i++;
                }
            }

            if(i == 2) {
                Double k = distance.getCoefficientByValue(enteredValues[0]);
                enteredValues[1] *= k;
            }
            if(i == 4){
                Double k =  weight.getCoefficientByValue(enteredValues[2]);
                enteredValues[3] *= k;
            }

            if (i == 4) {
                double calcResult = enteredValues[0] * enteredValues[1] + enteredValues[2] * enteredValues[3];
                System.out.println("Price $ " + calcResult);
                i = 0;
            }

        } while (!isExitValue(inputValue));

        System.out.println("Finish!");
    }

    private static boolean isExitValue(String value) {
        return value.equalsIgnoreCase("q");
    }

    private static boolean isCorrectDoubletValue(String value) {
        boolean checkResult;
        try {
            double enteredDoubleValue = Double.parseDouble(value);
            checkResult = enteredDoubleValue >= 0;

        } catch (NumberFormatException ex) {
            checkResult = false;
        }

        return checkResult;
    }

    private static List<String> readFormFile(String path) {
        List<String> strings = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                strings.add(line);
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }
}
