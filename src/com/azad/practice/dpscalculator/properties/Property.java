package com.azad.practice.dpscalculator.properties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Property {

    final List<Double> DEPOSITS = new ArrayList<>();
    final HashMap<Integer, Double> YEAR_RATE = new HashMap<>();
    int TABLE_CELL_SIZE;

    public abstract void init();

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
