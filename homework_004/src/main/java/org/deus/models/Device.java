package org.deus.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Device {
    private String name;
    private int year;
    private double price;
    private String color;
    private String type;
}
