package com.grabarski.mateusz.models.enums;

public enum Note {
    _200(200),
    _100(100),
    _50(50),
    _20(20),
    _10(10);

    private int value;

    Note(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
