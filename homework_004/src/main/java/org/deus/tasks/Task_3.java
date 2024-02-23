package org.deus.tasks;

import org.deus.models.Device;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task_3 implements Runnable
{

    @Override
    public void run() {
        System.out.println("--------------------------------");
        System.out.println("Task 3");
        System.out.println("--------------------------------");
        method();
        System.out.println("--------------------------------\n");
    }

    private void method() {
        List<Device> devices = Arrays.asList(
                new Device("Smartphone", 2022, 1000.0, "Black", "Mobile"),
                new Device("Laptop", 2021, 1500.0, "Silver", "Computer"),
                new Device("Tablet", 2023, 800.0, "White", "Mobile"),
                new Device("Smartwatch", 2022, 300.0, "Black", "Wearable"),
                new Device("Desktop", 2020, 2000.0, "Black", "Computer")
        );

        System.out.println("Усі пристрої:");
        devices.forEach(System.out::println);


        String color = "Black";
        List<Device> blackDevices = devices.stream()
                .filter(device -> device.getColor().equalsIgnoreCase(color))
                .toList();
        System.out.println("\nПристрої кольору " + color + ":");
        blackDevices.forEach(System.out::println);


        int year = 2022;
        List<Device> devicesOfYear = devices.stream()
                .filter(device -> device.getYear() == year)
                .toList();
        System.out.println("\nПристрої " + year + " року випуску:");
        devicesOfYear.forEach(System.out::println);


        double maxPrice = 1000.0;
        List<Device> expensiveDevices = devices.stream()
                .filter(device -> device.getPrice() > maxPrice)
                .toList();
        System.out.println("\nПристрої дорожчі за " + maxPrice + ":");
        expensiveDevices.forEach(System.out::println);


        String type = "Computer";
        List<Device> computerDevices = devices.stream()
                .filter(device -> device.getType().equalsIgnoreCase(type))
                .toList();
        System.out.println("\nПристрої типу " + type + ":");
        computerDevices.forEach(System.out::println);


        int startYear = 2021;
        int endYear = 2022;
        List<Device> devicesInYearRange = devices.stream()
                .filter(device -> device.getYear() >= startYear && device.getYear() <= endYear)
                .toList();
        System.out.println("\nПристрої в діапазоні випуску від " + startYear + " до " + endYear + ":");
        devicesInYearRange.forEach(System.out::println);
    }
}
