package com.instagram.model.valueObject;

public class Email {

    private final String value;

    public Email(String value) {
        if (value == null || !value.contains("@")) {
            throw new IllegalArgumentException("Email không hợp lệ.");
        }
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    @Override
    public String toString() {
        return value;
    }
}
