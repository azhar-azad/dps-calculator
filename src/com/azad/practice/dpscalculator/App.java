package com.azad.practice.dpscalculator;

import com.azad.practice.dpscalculator.utils.Utility;

class App {

    private String packageName;

    App() {
        setPackageName();
    }

    String getPackageName() {
        return packageName;
    }

    private void setPackageName() {
        showAvailablePackages();
        System.out.print("Enter your choice: ");
        int packageChoice = getPackageInput("Please enter integer value", 6);
        this.packageName = getPackageNameFromChoice(packageChoice);
    }

    private void showAvailablePackages() {

        System.out.println("This DPS packages are available right now.");
        System.out.println("MMSS (press 1)");
        System.out.println("SHWAPNO (press 2)");
        System.out.println("SHEFA (press 3)");
        System.out.println("FEMINA (press 4)");
        System.out.println("SU-GRIHINI (press 5)");
    }

    private int getPackageInput(String msg, int totalPackageCount) {
        int input = Utility.getIntegerInput(msg);

        if (input == 0) {
            return input;
        }

        if (input <= totalPackageCount) {
            return input;
        }

        System.out.println("Please enter value from given choices.");
        return getPackageInput(msg, totalPackageCount);
    }

    private String getPackageNameFromChoice(int packageChoice) {
        switch (packageChoice) {
            case 0:
                return "DEMO";
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
}
