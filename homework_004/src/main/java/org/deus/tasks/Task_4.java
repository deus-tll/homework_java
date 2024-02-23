package org.deus.tasks;

import org.deus.models.Projector;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task_4 implements Runnable
{

    @Override
    public void run() {
        System.out.println("--------------------------------");
        System.out.println("Task 4");
        System.out.println("--------------------------------");
        method();
        System.out.println("--------------------------------\n");
    }

    private void method() {
        List<Projector> projectors = Arrays.asList(
                new Projector("Projector1", 2020, 1200.0, "Manufacturer1"),
                new Projector("Projector2", 2021, 1500.0, "Manufacturer2"),
                new Projector("Projector3", 2022, 1800.0, "Manufacturer1"),
                new Projector("Projector4", 2022, 2000.0, "Manufacturer3"),
                new Projector("Projector5", 2023, 2200.0, "Manufacturer2")
        );


        System.out.println("Усі проектори:");
        projectors.forEach(System.out::println);


        String manufacturer = "Manufacturer1";
        List<Projector> manufacturerProjectors = projectors.stream()
                .filter(projector -> projector.getManufacturer().equalsIgnoreCase(manufacturer))
                .toList();
        System.out.println("\nПроектори виробника " + manufacturer + ":");
        manufacturerProjectors.forEach(System.out::println);


        int currentYear = 2022;
        List<Projector> currentYearProjectors = projectors.stream()
                .filter(projector -> projector.getYear() == currentYear)
                .toList();
        System.out.println("\nПроектори " + currentYear + " року:");
        currentYearProjectors.forEach(System.out::println);


        double maxPrice = 1800.0;
        List<Projector> expensiveProjectors = projectors.stream()
                .filter(projector -> projector.getPrice() > maxPrice)
                .toList();
        System.out.println("\nПроектори дорожчі за " + maxPrice + ":");
        expensiveProjectors.forEach(System.out::println);


        System.out.println("\nПроектори, відсортовані за ціною зростання:");
        projectors.stream()
                .sorted(Comparator.comparingDouble(Projector::getPrice))
                .forEach(System.out::println);


        System.out.println("\nПроектори, відсортовані за ціною спадання:");
        projectors.stream()
                .sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
                .forEach(System.out::println);


        System.out.println("\nПроектори, відсортовані за роком випуску:");
        projectors.stream()
                .sorted(Comparator.comparingInt(Projector::getYear))
                .forEach(System.out::println);


        System.out.println("\nПроектори, відсортовані за роком випуску у зворотному порядку:");
        projectors.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getYear(), p1.getYear()))
                .forEach(System.out::println);
    }
}
