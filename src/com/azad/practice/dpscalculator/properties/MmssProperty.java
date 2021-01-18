package com.azad.practice.dpscalculator.properties;

public class MmssProperty extends Property {

    public MmssProperty() {
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

        this.YEAR_RATE.put(3, 7.00);
        this.YEAR_RATE.put(5, 7.05);
        this.YEAR_RATE.put(8, 7.12);
        this.YEAR_RATE.put(10, 7.17);
        this.YEAR_RATE.put(12, 7.22);

        this.TABLE_CELL_SIZE = 15;
    }
}
