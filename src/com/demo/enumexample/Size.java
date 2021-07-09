package com.demo.enumexample;

public enum Size {
    SMALL("小"),
    LONG("长"),
    BIG("大");
    private String displayName;

    Size(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
