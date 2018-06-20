package date;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DateTimeAPI {
    public static void main(String args[]){
        /**
         * Cet exemple montre comment comparer deux dates en utilisant  java 8 date time api.
         */
        LocalDate currentDate = LocalDate.now();
        LocalDate date = LocalDate.of(2001,11,29);
        boolean isAfter = currentDate.isAfter(date);
        System.out.println(" --> verifier une date isAfter or isBefor");
        System.out.println("isAfter = "+isAfter);

        /**
         * Cet exemple montre comment ajouter un jour, mois et année pour une date ou enlever.
         */
        LocalDate newCurrentDate = LocalDate.now();
        System.out.println("\n --> ajouter + enlever : jour, mois et année");
        System.out.println("newCurrentDate = "+newCurrentDate);
        System.out.println("newCurrentDate - 1 ans = "+newCurrentDate.minusYears(1));
        System.out.println("newCurrentDate - 2 mois = "+newCurrentDate.minusMonths(2));
        System.out.println("newCurrentDate - 15 jours = "+newCurrentDate.minusDays(15));
        System.out.println("newCurrentDate + 12 jours = "+newCurrentDate.plusDays(12));
        System.out.println("newCurrentDate + 5 ans = "+newCurrentDate.plusYears(5));

        /**
         *  Cet exemple montre comment calculer les jours entre deux dates en utilisant java 8 Period.between et ChronoUnit.DAYS.between.
         */
        LocalDate birthDayDate = LocalDate.of(1992,9,13);
        long ageWithYears = Period.between(birthDayDate, LocalDate.now()).getYears();
        long ageWithMonth = ChronoUnit.MONTHS.between(birthDayDate, LocalDate.now());
        long ageWithDay_Chrono = ChronoUnit.DAYS.between(birthDayDate, LocalDate.now());
        System.out.println("\n --> calculer une période ou durée en jours, mois et années\n");
        System.out.println("ageWithYears = "+ageWithYears +" ans");
        System.out.println("ageWithMonth = "+ageWithMonth+" mois");
        System.out.println("ageWithDay_Chrono = "+ageWithDay_Chrono +" jours");
    }
}
