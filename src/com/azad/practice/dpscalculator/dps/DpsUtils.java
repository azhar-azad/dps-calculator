package com.azad.practice.dpscalculator.dps;

import com.azad.practice.dpscalculator.Properties;
import com.azad.practice.dpscalculator.Utility;

public class DpsUtils {

    private static Properties props = new Properties();

    public static Double getRateByYear(Integer year) {
        return props.getYearRate().get(year);
    }

    public static void showDeposits() {
        System.out.println("Available monthly deposit amounts: ");
        for (int i = 0; i < props.getDeposits().size(); i++) {
            System.out.print("| " + props.getDeposits().get(i) + " |");
        }
        System.out.println();
    }

    public static void showYearToInvests() {
        System.out.println("Available years to invest: ");
        for (Integer year: props.getYearRate().keySet()) {
            System.out.print("| " + year + " |");
        }
        System.out.println();
    }

    public static void showRates() {
        System.out.println("Available annual interest rates: ");
        for (Double rate: props.getYearRate().values()) {
            System.out.print("| " + rate + " |");
        }
        System.out.println();
    }

    public static double getMonthlyDepositInput(String msg) {
        double input = Utility.getDoubleInput(msg);

        if (props.getDeposits().contains(input)) {
            return input;
        }

        System.out.println("Please enter value from given choices.");
        return getMonthlyDepositInput(msg);
    }

    public static double getAIRInput(String msg) {
        double input = Utility.getDoubleInput(msg);

        if (props.getYearRate().containsValue(input)) {
            return input;
        }

        System.out.println("Please enter value from given choices.");
        return getMonthlyDepositInput(msg);
    }

    public static int getYearInput(String msg) {
        int input = Utility.getIntegerInput(msg);

        if (props.getYearRate().containsKey(input)) {
            return input;
        }

        System.out.println("Please enter value from given choices.");
        return getYearInput(msg);
    }
}
