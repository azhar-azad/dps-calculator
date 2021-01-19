package com.azad.practice.dpscalculator.properties;

public class MmssProperty extends Property {

    MmssProperty() {
        init();
    }

    @Override
    public void init() {
        DEPOSITS.add(200.0);
        DEPOSITS.add(500.0);
        DEPOSITS.add(1000.0);
        DEPOSITS.add(2000.0);
        DEPOSITS.add(5000.0);
        DEPOSITS.add(10000.0);
        DEPOSITS.add(20000.0);

        YEAR_RATE.put(3, 7.00);
        YEAR_RATE.put(5, 7.05);
        YEAR_RATE.put(8, 7.12);
        YEAR_RATE.put(10, 7.17);
        YEAR_RATE.put(12, 7.22);

        TABLE_CELL_SIZE = 15;
    }
}
