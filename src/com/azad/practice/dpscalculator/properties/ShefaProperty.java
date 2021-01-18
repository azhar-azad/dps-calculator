package com.azad.practice.dpscalculator.properties;

public class ShefaProperty extends Property {

    public ShefaProperty() {
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

        this.YEAR_RATE.put(3, 7.25);
        this.YEAR_RATE.put(5, 7.30);
        this.YEAR_RATE.put(8, 7.37);

        this.TABLE_CELL_SIZE = 15;
    }
}
