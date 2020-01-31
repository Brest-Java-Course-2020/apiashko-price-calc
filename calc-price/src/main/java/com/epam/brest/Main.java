package com.epam.brest;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Double[] enteredValues  = new Double[4];

        Scanner scanner = new Scanner(System.in);
        String inputValue;

        int i = 0;

        do{
            if(i == 0){
                System.out.println("Please enter distance or Q for exit : ");
            }else if(i == 1){
                System.out.println("Please enter price or Q for exit : ");
            }else if(i == 2){
                System.out.println("Please enter weight or Q for exit : ");
            } else{
                System.out.println("Please enter price par kg or Q for exit : ");
            }

            inputValue = scanner.next();

            if(!isExitValue(inputValue)){
                if(isCorrectDoubletValue(inputValue)){
                    enteredValues[i] = Double.parseDouble(inputValue);
                    i++;
                }
            }

            if(i == 4){
                double calcResult = enteredValues[0]*enteredValues[1] + enteredValues[2]*enteredValues[3];
                System.out.println("Price $ " + calcResult);
                i = 0 ;
            }

        } while(!isExitValue(inputValue));

        System.out.println("Finish!");
    }

    private static boolean isExitValue(String value){
        return value.equalsIgnoreCase("q");
    }

    private static boolean isCorrectValue(String value){
        return (isExitValue(value) || isCorrectDoubletValue(value));
    }

    private static boolean isCorrectDoubletValue(String value){
        boolean checkResult;
        try {
           double enteredDoubleValue =  Double.parseDouble(value);
           checkResult = enteredDoubleValue >= 0;

        } catch (NumberFormatException ex){
            checkResult = false;
        }

        return checkResult;
    }
}
