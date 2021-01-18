package com.azad.practice.dpscalculator;

import com.azad.practice.dpscalculator.dps.DpsCalculator;
import com.azad.practice.dpscalculator.dps.DpsUtils;

public class Main {

    public static void main(String[] args) {

//        DpsUtils.showDeposits();
//        System.out.print("Enter Monthly Deposit($): ");
//        double monthlyDeposit = DpsUtils.getMonthlyDepositInput("Please enter numeric value");
//
//        DpsUtils.showYearToInvests();
//        System.out.print("Enter years to invest: ");
//        int yearsToInvest = DpsUtils.getYearInput("Please enter integer value");
//
//        double annualInterestRate = DpsUtils.getRateByYear(yearsToInvest);
//
//        System.out.println();
//        System.out.println();
//
//        DpsCalculator calculator = new DpsCalculator(monthlyDeposit, annualInterestRate, yearsToInvest);
//        System.out.println("Total Deposits: " + calculator.getTotalDeposits());
//        System.out.println("Future Savings: " + calculator.getFutureSavings());
//        System.out.println("Interest Earned: " + calculator.getInterestEarned());
//        System.out.println(calculator.getDisclosure());

        TableBuilder tb = new TableBuilder();
        tb.printTable();
    }
}
