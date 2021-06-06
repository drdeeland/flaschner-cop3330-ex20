/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Dillon Flaschner
 */

package base;

import java.util.Scanner;

public class App {
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();

        String orderString = myApp.orderInput();
        String state = myApp.stateInput();
        String county = myApp.countyInput();

        int order = Integer.parseInt(orderString);
        double taxRate = myApp.taxRateCalc(state, county);
        double tax = myApp.taxCalc(order, taxRate);
        double total = myApp.totalCalc(order, tax);

        String output = myApp.buildOutput(tax, total);
        myApp.printOutput(output);
    }

    public String orderInput() {
        System.out.print("What is the order amount? ");
        return input.nextLine();
    }

    public String stateInput() {
        System.out.print("What state do you live in? ");
        return input.nextLine();
    }

    public String countyInput() {
        System.out.print("What county do you live in? ");
        return input.nextLine();
    }

    public double taxRateCalc(String state, String county) {
        switch (state) {
            case "Wisconsin":
                switch (county) {
                    case "Eau Claire":
                        return 0.055;

                    case "Dane":
                        return 0.054;

                    default:
                        return 0.05;
                }

            case "Illinois":
                return 0.08;

            default:
                return 0;
        }
    }

    public double taxCalc(int order, double taxRate) {
        return order * taxRate;
    }

    public double totalCalc(int order, double tax) {
        return order + tax;
    }

    public String buildOutput(double tax, double total) {
        String taxString = String.format("$%.2f", tax);
        String totalString = String.format("$%.2f", total);
        return "The tax is " + taxString + ".\nThe total is " + totalString + ".";
    }

    public void printOutput(String output) {
        System.out.print(output);
    }
}