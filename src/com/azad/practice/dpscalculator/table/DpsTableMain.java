package com.azad.practice.dpscalculator.table;

public class DpsTableMain {

    public static void main(String[] args, String packageName) {

       try {
           TableBuilder tb = new TableBuilder(packageName);
           tb.printTable();
       }
       catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }


}
