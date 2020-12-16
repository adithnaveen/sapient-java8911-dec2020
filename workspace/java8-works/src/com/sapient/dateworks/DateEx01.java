package com.sapient.dateworks;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class DateEx01 {
	public static void main(String[] args) {
		// old code
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, 8);
		System.out.println("After adding 8 Hrs : " + cal.getTime());

		// java 8
		LocalTime now = LocalTime.now();

		LocalTime plus8Hrs = now.plus(8, ChronoUnit.HOURS);
		System.out.println("After adding 8 hrs (Java8) : " + plus8Hrs);

//		 to  add 30 days 
		LocalDate today = LocalDate.now();
		System.out.println("after adding 30 days : " + today.plusDays(30));
		System.out.println("After adding 1 month : " + today.plusMonths(1));
		System.out.println("Before 1 month : " + today.minusMonths(1));

		LocalTime newTime = LocalTime.of(22, 10, 50);
		System.out.println("New Time " + newTime);

		LocalDate newDate = LocalDate.of(2020, Month.DECEMBER, 15);
		System.out.println("New Date :" + newDate);

		System.out.println(Clock.systemDefaultZone());
		System.out.println("----------------------------------------------");
		ZoneId.getAvailableZoneIds().forEach(System.out::println);

		System.out.println("----------------------------------------------");
		// America/Chicago
		ZoneId chicagoZoneId = ZoneId.of("America/Chicago");
		LocalTime chicagoTime = LocalTime.now(chicagoZoneId);
		System.out.println("Chicago Time " + chicagoTime);

		LocalDate date1 = LocalDate.now();
		LocalDate date2 = LocalDate.of(2004, Month.MARCH, 14);

		Period between = Period.between(date1, date2);
		System.out.println(between);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM-dd-yyyy");

		String myDate = "16-12-2020";

		System.out.println(LocalDate.parse(myDate, formatter).format(formatter1));

	}
}
