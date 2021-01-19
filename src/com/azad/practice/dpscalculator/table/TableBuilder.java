package com.azad.practice.dpscalculator.table;

import com.azad.practice.dpscalculator.properties.Property;
import com.azad.practice.dpscalculator.calculator.DpsCalculator;
import com.azad.practice.dpscalculator.properties.PropertiesFactory;

class TableBuilder {

    private Property props;
    private String table;
    private String tableHeader;
    private String tableBody;
    private String tableFooter;
    private String rowSeparator;

    TableBuilder(String packageName) {
        PropertiesFactory propsFactory = new PropertiesFactory();
        try {
            props = propsFactory.getProperties(packageName);
            if (props == null) {
                throw new ClassNotFoundException("The package \"" + packageName + "\" is not found.");
            }
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        tableHeader = "|" + addPadding("Year") + "|" + addPadding("Rate(%)") + "|";
        tableBody = "";
        tableFooter = "";
        table = "";
        buildRowSeparator();
        buildTableHeader();
        buildTableBody();
        buildTableFooter();
        buildTable();
    }

    void printTable() {
        System.out.println(table);
    }

    /*
    PRIVATE METHODS
     */
    private void buildTableHeader() {
        System.out.println(rowSeparator);
        StringBuilder tableHeaderBuilder = new StringBuilder();
        for (Double item: props.getDeposits()) {
            tableHeaderBuilder.append(addPadding(item+"")).append("|");
        }
        tableHeader += tableHeaderBuilder.toString();
    }

    private void buildTableBody() {
        StringBuilder tableBodyBuilder = new StringBuilder();
        for (Integer year: props.getYearRate().keySet()) {
            Double rate = props.getYearRate().get(year);
            String tableRow = "";
            tableRow += "|" + addPadding(year+"") + "|" + addPadding(rate+"") + "|";
            StringBuilder tableRowBuilder = new StringBuilder();
            for (Double deposit: props.getDeposits()) {
                DpsCalculator dc = new DpsCalculator(deposit, rate, year);
                tableRowBuilder.append(addPadding(dc.getFutureSavings())).append("|");
            }
            tableRow += tableRowBuilder.toString();
            tableBodyBuilder.append(tableRow).append("\n");
        }
        tableBody += tableBodyBuilder.toString();
        tableBody += rowSeparator;
    }

    private void buildTableFooter() {
        tableFooter += "All values are rounded (approx.)";
    }

    private void buildTable() {
        table += tableHeader;
        table += "\n" + getHeaderBodySeparator() + "\n";
        table += tableBody;
        table += "\n";
        table += tableFooter;
    }

    private String getHeaderBodySeparator() {
        StringBuilder hbSeparator = new StringBuilder();
        for (int i = 0; i < rowSeparator.length(); i++) {
            if (rowSeparator.charAt(i) == '-') {
                hbSeparator.append('=');
            }
            else
                hbSeparator.append(rowSeparator.charAt(i));
        }
        return hbSeparator.toString();
    }

    private void buildRowSeparator() {
        /*
        This method will build the separator between two rows in the table.
        cellUnit:
        =========
        Depending on the value of TABLE_CELL_SIZE in Property a "cellUnit" will be built.
        A "cellUnit" will look like this: ---------------|

        rowSeparator:
        =============
        The length of the "rowSeparator" depends on the number of monthly deposit amount available
        for a given DPS scheme. For example, DEMO package has 4 (500, 1000, 5000, 10000).
        So for DEMO package, "rowSeparator" will be 4+2=6 cellUnit long.
        Extra 2 cellUnits are added for Year and Rate column.
         */
        StringBuilder cellUnitBuilder = new StringBuilder(); // cellUnit = ""
        for (int i = 0; i < props.getTableCellSize(); i++) {
            cellUnitBuilder.append("-");
        }   // cellUnit = "---------------"
        cellUnitBuilder.append("|");    // cellUnit = "---------------|"

        StringBuilder rowSeparatorBuilder = new StringBuilder("|");  // rowSeparator = "|"
        for (int i = 0; i < props.getDeposits().size() + 2; i++) {
            rowSeparatorBuilder.append(cellUnitBuilder);
        }   // rowSeparator = "|---------------|---------------|---------------|---------------|---------------|---------------|"

        this.rowSeparator = rowSeparatorBuilder.toString();
    }

    private String addPadding(String cellItem) {
        /*
        To give the table a nice and organized view,
        each cell item will be given an extra padding on the left side of the value.
        i.e. with padding "Year" will look like "      Year".

        If the value of TABLE_CELL_SIZE in Property class is 10,
        and the cellItem's length is 4,
        then padding length will be 10-4=6. i.e. padding = "      ".
        This padding will be appended to the left side of the cellItem and returned.
         */
        int cellSize = props.getTableCellSize();

        StringBuilder paddingBuilder = new StringBuilder();

        for (int i = 0; i < cellSize - cellItem.length(); i++) {
            paddingBuilder.append(" ");
        }

        return paddingBuilder + cellItem;
    }
}
