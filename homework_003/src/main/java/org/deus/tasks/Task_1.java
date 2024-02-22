package org.deus.tasks;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;

public class Task_1 implements Runnable
{

    @Override
    public void run() {
        System.out.println("--------------------------------");
        System.out.println("Task 1");
        System.out.println("--------------------------------");
        method();
        System.out.println("--------------------------------\n");
    }

    private void method() {
        // 1
        Function<Integer, Boolean> isLeapYear = year -> Year.of(year).isLeap();
        System.out.println("2023 is leap year: " + isLeapYear.apply(2023));
        System.out.println("2024 is leap year: " + isLeapYear.apply(2024));

        // 2
        Function<LocalDate[], Long> daysBetween = dates -> ChronoUnit.DAYS.between(dates[0], dates[1]);
        LocalDate[] datesDays = {LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31)};
        System.out.println("Days between 2024-01-01 and 2024-12-31: " + daysBetween.apply(datesDays));

        // 3
        Function<LocalDate[], Long> weeksBetween = dates -> ChronoUnit.WEEKS.between(dates[0], dates[1]);
        LocalDate[] datesWeeks = {LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31)};
        System.out.println("Weeks between 2024-01-01 and 2024-12-31: " + weeksBetween.apply(datesWeeks));

        // 4
        Function<LocalDate, DayOfWeek> dayOfWeek = LocalDate::getDayOfWeek;
        LocalDate date = LocalDate.of(1911, 5, 4);
        System.out.println("Day of the week for 1911-05-04: " + dayOfWeek.apply(date));
    }
}