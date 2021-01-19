package com.azad.practice.dpscalculator;

import com.azad.practice.dpscalculator.calculator.DpsCalculatorMain;
import com.azad.practice.dpscalculator.table.DpsTableMain;
import com.azad.practice.dpscalculator.utils.Utility;

public class Main {

    private static App app = new App();

    public static void main(String[] args) {

        String packageName = app.getPackageName();
        System.out.println("\"" + packageName + "\" selected.\n");

        System.out.println("1. Calculate DPS by inputting properties (press 1)");
        System.out.println("2. Display DPS scheme in a table (press 2)");
        System.out.print("Enter choice: ");

        int choice = Utility.getIntegerInput("Please enter integer value.");

        switch (choice) {
            case 1:
                DpsCalculatorMain.main(packageName);
                break;
            case 2:
                DpsTableMain.main(packageName);
                break;

             default:
                 System.out.println("Invalid choice");
        }
    }
}
