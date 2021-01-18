package com.azad.practice.dpscalculator;

import com.azad.practice.dpscalculator.dps.DpsCalculator;

public class TableBuilder {

    private Properties props = new Properties();

    private String table;
    private String tableHeader;
    private String tableBody;

    public TableBuilder() {
        tableHeader = "|" + addPadding("Year") + "|" + addPadding("Rate(%)") + "|";
        tableBody = "";
        table = "";
        buildTableHeader();
        buildTableBody();
        buildTable();
    }

    public void printTable() {
        System.out.println(table);
    }

    private void buildTable() {
        table += tableHeader;
        table += "\n";
        table += tableBody;
    }

    private void buildTableHeader() {
        System.out.println(getRowSeparator());
        for (Double item: props.getDeposits()) {
            tableHeader += addPadding(item + "") + "|";
        }
    }

    private void buildTableBody() {
        for (Integer year: props.getYearRate().keySet()) {
            tableBody += getRowSeparator() + "\n";
            Double rate = props.getYearRate().get(year);
            String tableRow = "";
            tableRow += "|" + addPadding(year+"") + "|" + addPadding(rate+"") + "|";
            for (Double deposit: props.getDeposits()) {
                DpsCalculator dc = new DpsCalculator(deposit, rate, year);
                tableRow += addPadding(dc.getFutureSavings()) + "|";
            }
            tableBody += tableRow + "\n";
        }
        tableBody += getRowSeparator();
    }

    private String getRowSeparator() {
        String unit = "";
        for (int i = 0; i < props.getTableCellSize(); i++) {
            unit += "-";
        }
        unit += "|";
        String rowSeparator = "|";
        for (int i = 0; i < 9; i++) {
            rowSeparator += unit;
        }
        return rowSeparator;
    }

    private String addPadding(String item) {
        int cellSize = props.getTableCellSize();

        String padding = "";

        for (int i = 0; i < cellSize - item.length(); i++) {
            padding += " ";
        }

        return padding + item;
    }
}
