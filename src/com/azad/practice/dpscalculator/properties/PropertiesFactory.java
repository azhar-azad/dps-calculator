package com.azad.practice.dpscalculator.properties;

public class PropertiesFactory {

    public Property getProperties(String packageName) {

        if (packageName.equalsIgnoreCase("DEMO")) {
            return new DemoProperty();
        }
        else if (packageName.equalsIgnoreCase("MMSS")) {
            return new MmssProperty ();
        }
        else if (packageName.equalsIgnoreCase("SHWAPNO") ||
                packageName.equalsIgnoreCase("FEMINA") ||
                packageName.equalsIgnoreCase("SU-GRIHINI")) {
            return new ShwapnoProperty();
        }
        else if (packageName.equalsIgnoreCase("SHEFA")) {
            return new ShefaProperty();
        }
        return null;
    }
}
