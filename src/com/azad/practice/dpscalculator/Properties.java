package com.azad.practice.dpscalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Properties {

    private final List<Double> DEPOSITS = new ArrayList<>();
    private final HashMap<Integer, Double> YEAR_RATE = new HashMap<>();
    private int TABLE_CELL_SIZE;

    public Properties() {
        DEPOSITS.add(200.0);
        DEPOSITS.add(500.0);
        DEPOSITS.add(1000.0);
        DEPOSITS.add(2000.0);
        DEPOSITS.add(5000.0);
        DEPOSITS.add(10000.0);
        DEPOSITS.add(20000.0);

        YEAR_RATE.put(3, 7.25);
        YEAR_RATE.put(5, 7.30);
        YEAR_RATE.put(8, 7.37);
        YEAR_RATE.put(10, 7.42);
        YEAR_RATE.put(12, 7.47);

        TABLE_CELL_SIZE = 15;
    }

    public List<Double> getDeposits() {
        return DEPOSITS;
    }

    public HashMap<Integer, Double> getYearRate() {
        return YEAR_RATE;
    }

    public int getTableCellSize() {
        return TABLE_CELL_SIZE;
    }
}
