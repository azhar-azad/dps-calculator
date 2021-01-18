package com.azad.practice.dpscalculator.calculator;

import com.azad.practice.dpscalculator.utils.DpsUtils;

public class DpsCalculatorMain {

    public static void main(String[] args, String packageName) {

        DpsUtils dpsUtils = new DpsUtils(packageName);

        dpsUtils.showDeposits();
        System.out.print("Enter Monthly Deposit($): ");
        double monthlyDeposit = dpsUtils.getMonthlyDepositInput("Please enter numeric value");

        dpsUtils.showYearToInvests();
        System.out.print("Enter years to invest: ");
        int yearsToInvest = dpsUtils.getYearInput("Please enter integer value");

        double annualInterestRate = dpsUtils.getRateByYear(yearsToInvest);

        System.out.println();
        System.out.println();

        DpsCalculator calculator = new DpsCalculator(monthlyDeposit, annualInterestRate, yearsToInvest);
        System.out.println("Total Deposits: " + calculator.getTotalDeposits());
        System.out.println("Future Savings: " + calculator.getFutureSavings());
        System.out.println("Interest Earned: " + calculator.getInterestEarned());
        System.out.println(calculator.getDisclosure());
    }
}
