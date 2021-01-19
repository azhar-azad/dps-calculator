package com.azad.practice.dpscalculator.calculator;

public class DpsCalculator {

    private double monthlyDeposit;
    private double annualInterestRate;
    private int yearsToInvest;

    private double futureSavings;
    private double totalDeposits;
    private double interestEarned;

    public DpsCalculator(double monthlyDeposit, double annualInterestRate, int yearsToInvest) {
        this.monthlyDeposit = monthlyDeposit;
        this.annualInterestRate = annualInterestRate;
        this.yearsToInvest = yearsToInvest;
    }

    /*
    PUBLIC METHODS
     */
    public String getFutureSavings() {
        double factor = annualInterestRate / (12 * 100);
        futureSavings = getFutureSavings(monthlyDeposit, factor, yearsToInvest * 12);
        return getCurrencyFormattedValue(futureSavings);
    }

    /*
    PACKAGE-PRIVATE METHODS
     */
    String getTotalDeposits() {
        totalDeposits = getTotalDeposits(monthlyDeposit, yearsToInvest * 12);
        return getCurrencyFormattedValue(totalDeposits);
    }

    String getInterestEarned() {
        interestEarned = getInterestEarned(futureSavings, totalDeposits);
        return getCurrencyFormattedValue(interestEarned);
    }

    String getDisclosure() {
        return "\nIf you make regularly monthly deposits of " + getCurrencyFormattedValue(monthlyDeposit) + " for "
                + yearsToInvest + " years (or " + yearsToInvest*12 + " months), you will earn " + getCurrencyFormattedValue(interestEarned)
                + " in interest at a " + annualInterestRate + "% APR with interest compounded monthly.\nThis will grow "
                + "your savings from " + getCurrencyFormattedValue(totalDeposits) + " to " + getCurrencyFormattedValue(futureSavings)
                + " after the " + getCurrencyFormattedValue(interestEarned) + " in interest is added to your savings.";
    }

    /*
    PRIVATE METHODS
    */
    private String getCurrencyFormattedValue(double value) {

        String strValue = decimalRounder(value) + "";

        int decimalPointMark = strValue.indexOf(".");

        String mainPart = strValue.substring(0, decimalPointMark);
        String fractionPart = strValue.substring(decimalPointMark+1);

        if (mainPart.length() <= 3) {
            return "$" + mainPart + "." + fractionPart;
        }

        String unformattedMainPart = mainPart;
        String formattedValue = "";
        int part;
        for (int i = 0; i < mainPart.length(); i += part) {

            if (unformattedMainPart.length() % 3 == 2) {
                part = 2;
            }
            else if (unformattedMainPart.length() % 3 == 1) {
                part = 1;
            }
            else
                part = 3;

            formattedValue += unformattedMainPart.substring(0, part) + ",";
            unformattedMainPart = unformattedMainPart.substring(part);
        }

        formattedValue = formattedValue.substring(0, formattedValue.length() - 1);
        return "$" + formattedValue + "." + fractionPart;
    }

    private double decimalRounder(double value) {
        /*
        formatFactor = 1.0 --> will not show decimal part. decimal part will get rounded with the non-decimal part // 123.0
        formatFactor = 10.0 --> will show decimal part up to 1 digit // 123.6
        formatFactor = 100.0 --> will show decimal part upt o 2 digits // 123.57
        formatFactor = 1000.0 --> will show decimal part up to 3 digits // 123.567
        .... so on
         */
        double formatFactor = 1.0;
        return Math.round(value * formatFactor) / formatFactor;
    }

    private double getInterestEarned(double futureSavings, double totalDeposits) {
        return futureSavings - totalDeposits;
    }

    private double getTotalDeposits(double monthlyDeposit, int monthsToInvest) {
        return monthlyDeposit * monthsToInvest;
    }

    private double getFutureSavings(double monthlyDeposit, double factor, int monthsToInvest) {

        if (monthsToInvest == 1) {
            return monthlyDeposit;
        }

        monthlyDeposit += monthlyDeposit * factor;

        return monthlyDeposit + getFutureSavings(monthlyDeposit, factor, monthsToInvest - 1);
    }
}
