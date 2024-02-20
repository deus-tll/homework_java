package org.deus.task_3;

public class Penalty {
    private final String type;
    private final String city;
    private final double amount;

    // Конструктор, гетери та сетери

    public Penalty(String type, String city, double amount) {
        this.type = type;
        this.city = city;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public String getCity() {
        return city;
    }

    public double getAmount() {
        return amount;
    }
}
