package com.azad.practice.dpscalculator.table;

import com.azad.practice.dpscalculator.properties.Property;
import com.azad.practice.dpscalculator.calculator.DpsCalculator;
import com.azad.practice.dpscalculator.properties.PropertiesFactory;

public class TableBuilder {

    private Property props;
    private String table;
    private String tableHeader;
    private String tableBody;

    public TableBuilder(String packageName) throws ClassNotFoundException {
        PropertiesFactory propsFactory = new PropertiesFactory();
        props = propsFactory.getProperties(packageName);

        if (props == null) {
            throw new ClassNotFoundException("The package \"" + packageName + "\" is not found.");
        }

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
