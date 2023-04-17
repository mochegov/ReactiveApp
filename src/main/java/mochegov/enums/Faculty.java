package mochegov.enums;

public enum Faculty {
    BOODY ("Оболтусы"),
    HOOLIGANS ("Хулиганы"),
    LAZY ("Лентяи");
    private String name;

    Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
