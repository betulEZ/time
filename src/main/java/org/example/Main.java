package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws ParseException {

        ZonedDateTime zonedDateTime= ZonedDateTime.now();
        System.out.println("current Time"+zonedDateTime);

        //add 2 week to the current date
        ZonedDateTime next2Week = zonedDateTime.plus(2, ChronoUnit.WEEKS);
        System.out.println("Next2 week: " + next2Week);

        //dates to be compared
        SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdfo.parse("2022-01-06");
        Date date2 = sdfo.parse("2020-01-01");

        if(date1.after(date2))
            System.out.println("date1 comes after Date2");
        else if (date1.before(date2)) {
            System.out.println("date1 comes before Date2");
        }

        //Calculate the difference in days between two arbitrary dates and output the result.
        long diff = date2.getTime() - date1.getTime();
        System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));


        //next birthday of the animal
        Animal animal=new Animal(LocalDate.of(2023,2,3),"Dog");
        LocalDate dateBirthday = animal.getBirthday();
        LocalDate today = LocalDate.now();
        LocalDate nextBDay = dateBirthday.withYear(today.getYear());

        //If your birthday has occurred this year already, add 1 to the year.
        if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
            nextBDay = nextBDay.plusYears(1);
        }

        Period p = Period.between(today, nextBDay);
        long p2 = ChronoUnit.DAYS.between(today, nextBDay);
        System.out.println("There are " + p.getMonths() + " months, and " +  p.getDays() + " days until your next birthday. (" + p2 + " total)");

    }
}