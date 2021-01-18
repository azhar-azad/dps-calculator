package com.azad.practice.dpscalculator;

import com.azad.practice.dpscalculator.calculator.DpsCalculatorMain;
import com.azad.practice.dpscalculator.table.DpsTableMain;
import com.azad.practice.dpscalculator.utils.DpsUtils;
import com.azad.practice.dpscalculator.utils.Utility;

public class Main {

    public static void main(String[] args) {

        showAvailablePackages();
        System.out.print("Enter your choice: ");
        int packageChoice = DpsUtils.getPackageInput("Please enter integer value", 5);
        String packageName = getPackageNameFromChoice(packageChoice);
        System.out.println("\"" + packageName + "\" selected.\n");

        System.out.println("1. Calculate DPS by inputting properties (press 1)");
        System.out.println("2. Display DPS scheme in a table (press 2)");
        System.out.print("Enter choice: ");

        int choice = Utility.getIntegerInput("Please enter integer value.");

        switch (choice) {
            case 1:
                DpsCalculatorMain.main(args, packageName);
                break;
            case 2:
                DpsTableMain.main(args, packageName);
                break;

             default:
                 System.out.println("Invalid choice");
        }
    }

    private static String getPackageNameFromChoice(int packageChoice) {
        switch (packageChoice) {
            case 1:
                return "MMSS";
            case 2:
                return "SHWAPNO";
            case 3:
                return "SHEFA";
            case 4:
                return "FEMINA";
            case 5:
                return "SU-GRIHINI";
            default:
                return "INVALID";
        }
    }

    private static void showAvailablePackages() {

        System.out.println("This DPS packages are available right now.");
        System.out.println("MMSS (press 1)");
        System.out.println("SHWAPNO (press 2)");
        System.out.println("SHEFA (press 3)");
        System.out.println("FEMINA (press 4)");
        System.out.println("SU-GRIHINI (press 5)");
    }
}
