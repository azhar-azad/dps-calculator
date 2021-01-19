package com.azad.practice.dpscalculator.utils;

import com.azad.practice.dpscalculator.properties.PropertiesFactory;
import com.azad.practice.dpscalculator.properties.Property;

public class DpsUtils {

    private Property props;

    public DpsUtils(String packageName) {
        PropertiesFactory propsFactory = new PropertiesFactory();
        props = propsFactory.getProperties(packageName);
    }

    public Double getRateByYear(Integer year) {

        return props.getYearRate().get(year);
    }

    public void showDeposits() {
        System.out.println("Available monthly deposit amounts: ");
        for (int i = 0; i < props.getDeposits().size(); i++) {
            System.out.print("| " + props.getDeposits().get(i) + " |");
        }
        System.out.println();
    }

    public void showYearToInvests() {
        System.out.println("Available years to invest: ");
        for (Integer year: props.getYearRate().keySet()) {
            System.out.print("| " + year + " |");
        }
        System.out.println();
    }

    public double getMonthlyDepositInput(String msg) {
        double input = Utility.getDoubleInput(msg);

        if (props.getDeposits().contains(input)) {
            return input;
        }

        System.out.println("Please enter value from given choices.");
        return getMonthlyDepositInput(msg);
    }

    public int getYearInput(String msg) {
        int input = Utility.getIntegerInput(msg);

        if (props.getYearRate().containsKey(input)) {
            return input;
        }

        System.out.println("Please enter value from given choices.");
        return getYearInput(msg);
    }
}
