package com;

public enum Meiju {
    WE("nnkj"),
    RT("lkm"),
    ER(" m,");
    private String name;

    Meiju(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
