package ru.vasilkov.Service1.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Systems {
    ERP("Enterprise Resource Planning"),
    CRM("Customer Relationship Management"),
    WMS("Warehouse Management System"),
    SERVICEONE("Service1");

    private final String system;

    Systems(String name) {
        this.system = name;
    }

    @JsonValue
    public String getName() {
        return system;
    }

    @Override
    public String toString() {
        return system;
    }
}
