package org.deus.tasks;

import org.deus.helpers.Fraction;

import java.util.function.BinaryOperator;

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
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 3);


        BinaryOperator<Fraction> addFractions = (f1, f2) ->
                new Fraction(
                        f1.getNumerator() * f2.getDenominator() + f2.getNumerator() * f1.getDenominator(),
                        f1.getDenominator() * f2.getDenominator()
                );

        Fraction sum = addFractions.apply(fraction1, fraction2);
        System.out.println("Sum of fractions " + fraction1 + " and " + fraction2 + ": " + sum);


        BinaryOperator<Fraction> subtractFractions = (f1, f2) ->
                new Fraction(
                        f1.getNumerator() * f2.getDenominator() - f2.getNumerator() * f1.getDenominator(),
                        f1.getDenominator() * f2.getDenominator()
                );
        Fraction difference = subtractFractions.apply(fraction1, fraction2);
        System.out.println("Difference of fractions " + fraction1 + " and " + fraction2 + ": " + difference);


        BinaryOperator<Fraction> multiplyFractions = (f1, f2) ->
                new Fraction(
                        f1.getNumerator() * f2.getNumerator(),
                        f1.getDenominator() * f2.getDenominator()
                );
        Fraction product = multiplyFractions.apply(fraction1, fraction2);
        System.out.println("Product of fractions " + fraction1 + " and " + fraction2 + ": " + product);


        BinaryOperator<Fraction> divideFractions = (f1, f2) ->
                new Fraction(
                        f1.getNumerator() * f2.getDenominator(),
                        f1.getDenominator() * f2.getNumerator()
                );
        Fraction division = divideFractions.apply(fraction1, fraction2);
        System.out.println("Division of fractions " + fraction1 + " and " + fraction2 + ": " + division);
    }
}