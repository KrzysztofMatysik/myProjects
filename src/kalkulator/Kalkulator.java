/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Kriss
 */
public class Kalkulator implements FunkcjeKalkulatora {

    private double[] tableNumbers;
    private Scanner input = new Scanner(System.in);
    private boolean closeProgram = false;
    private double result = 0;
    private boolean isPrevRes = false;
    private double previouslyResult = 0;

    /**
     * The function responsible for additon numbers.
     *
     * @param number
     * @return addition results
     */
    @Override
    public double additionNumbers(double... number) {

        if (isPrevRes == true) {
            this.result = previouslyResult;
            isPrevRes = false;

        } else {
            this.result = 0;
        }

        for (double d : number) {

            result += d;
        }

        return result;
    }

    /**
     * The function responsible for substraction numbers.
     *
     * @param numbers
     * @return substraction results
     */
    @Override
    public double subtractionNumbers(double... numbers) {

        if (isPrevRes == true) {
            this.result = previouslyResult;
            isPrevRes = false;

        } else {
            this.result = 0;
        }

        for (double d : numbers) {

            result -= d;
        }
        return result;
    }

    /**
     * The function responsible for multiplication numbers.
     *
     * @param numbers
     * @return multiplication results
     */
    @Override
    public double multiplicationNumbers(double... numbers) {

        if (isPrevRes == true) {
            this.result = previouslyResult;
            isPrevRes = false;

        } else {
            this.result = 1;
        }
        for (double d : numbers) {

            result *= d;
        }
        return result;
    }

    @Override
    public double divisionNumbers(double... numbers) {

        if (isPrevRes == true) {
            this.result = previouslyResult;
            isPrevRes = false;

        } else {
            this.result = 0;
        }

        for (int i = 0; i < numbers.length; i++) {

            if (i == 0) {
                result = numbers[i];
            } else {
                result /= numbers[i];
            }
        }

        //double formatNumber = Double.valueOf(System.out.format("%.2d%n", results).toString());
        //return formatNumber;
        return result;
    }

    public void startCalculator() {

        System.out.println("Welcome to the simply calculator. Please select one of the options below: " + "\n"
                + "1. Addidtion" + "\n"
                + "2. Subtraction" + "\n"
                + "3. Multiplication " + "\n"
                + "4. Division " + "\n");

        int tmpChoice = input.nextInt();

        checkChoise(tmpChoice);
    }

    public void takeManyNumbers() {
        int tmpEndCondition = 0;

        ArrayList<Double> tmpStorageNumbers = new ArrayList<>(100);

        System.out.println("\n" + "Please enter number which you want to submit to the chosen action. When something other than a number is entered,"
                + " the program will perform the action on all previously entered numbers. ");
        if (isPrevRes == true) {
            System.out.println("Previously value is " + previouslyResult);
        }
        do {
            try {

                tmpStorageNumbers.add(Double.valueOf(input.next().replaceAll(",", ".")));

            } catch (Exception e) {
                tmpEndCondition = 1;
            }
        } while (tmpEndCondition
                != 1);

        tableNumbers = new double[tmpStorageNumbers.size()];
        for (int i = 0; i < tmpStorageNumbers.size(); i++) {
            tableNumbers[i] = tmpStorageNumbers.get(i);
        }

    }

    public void wrongOption() {

        System.out.println("You choice wrong option. Please try again! ");
    }

    public void usingResults() {

        String tmpAnswer = "";

        do {
            System.out.println("Do you want use the previousing obtained value? Y/y or N/n");

            switch (tmpAnswer = input.next()) {

                case "Y":
                case "y":
                    previouslyResult = this.result;
                    this.isPrevRes = true;
                    startCalculator();
                    break;
                case "N":
                case "n":
                    previouslyResult = 0;
                    startCalculator();
                    break;
                default:
                    System.out.println("You can choise only options Y/y or N/n. Please try again!");
            }

        } while (!tmpAnswer.equals("Y") || !tmpAnswer.equals("y") || !tmpAnswer.equals("N") || !tmpAnswer.equals("n"));
    }

    public void closingProgram() {

        String tmpAnswer = "";

        do {
            System.out.println("\n" + "Do you want to do something else? ");
            switch (tmpAnswer = input.next()) {
                case "Y":
                case "y":
                    usingResults();
                    break;
                case "N":
                case "n":
                    System.exit(0);
                    break;
                default:
                    System.out.println("You choise wrong answer. Pleas try again!");
            }

        } while (!tmpAnswer.equals("Y") || !tmpAnswer.equals("y") || !tmpAnswer.equals("N") || !tmpAnswer.equals("n"));
    }

    void checkChoise(int choiseOption) {
        do {
            switch (choiseOption) {

                case 1:
                    takeManyNumbers();
                    System.out.print(additionNumbers(tableNumbers));
                    closingProgram();
                    break;
                case 2:
                    takeManyNumbers();
                    System.out.print(subtractionNumbers(tableNumbers));
                    closingProgram();
                    break;
                case 3:
                    takeManyNumbers();
                    System.out.print(multiplicationNumbers(tableNumbers));
                    closingProgram();
                    break;
                case 4:
                    takeManyNumbers();
                    System.out.print(divisionNumbers(tableNumbers));
                    closingProgram();
                    break;
                default:
                    wrongOption();

            }

        } while (closeProgram != false);

    }

    public static void main(String[] args) {

        Kalkulator first = new Kalkulator();
        first.startCalculator();

    }

}
