package org.deus.tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_2 implements Runnable
{
    @Override
    public void run() {
        System.out.println("--------------------------------");
        System.out.println("Task 2");
        System.out.println("--------------------------------");
        method();
        System.out.println("--------------------------------\n");
    }

    private void method() {
        List<String> products = Arrays.asList(
                "Молоко", "Яйця", "Хліб", "Масло", "Сир", "Мед", "М'ясо", "Макарони", "Морозиво", "Мандарини"
        );


        System.out.println("Усі продукти: " + products);


        List<String> shortNamedProducts = products.stream()
                .filter(product -> product.length() < 5)
                .toList();
        System.out.println("Продукти з назвою менше п'яти символів: " + shortNamedProducts);


        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть назву продукту для підрахунку: ");
        String userInput = scanner.nextLine();
        long count = products.stream()
                .filter(product -> product.equalsIgnoreCase(userInput))
                .count();
        System.out.println("Кількість зустрічей продукту \"" + userInput + "\": " + count);


        System.out.print("Введіть літеру для фільтрації продуктів: ");
        char startLetter = scanner.nextLine().charAt(0);
        List<String> productsStartWithLetter = products.stream()
                .filter(product -> product.toLowerCase().startsWith(String.valueOf(startLetter).toLowerCase()))
                .toList();
        System.out.println("Продукти, які починаються на літеру \"" + startLetter + "\": " + productsStartWithLetter);


        List<String> milkProducts = products.stream()
                .filter(product -> product.equalsIgnoreCase("Молоко"))
                .toList();
        System.out.println("Продукти категорії «Молоко»: " + milkProducts);
    }
}
