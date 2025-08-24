package Java8Features;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeApiExample {
    public static void main(String[] args) {

        // ---------------------------
        // 1. Working with LocalDate
        // ---------------------------
        LocalDate today = LocalDate.now(); // Current date
        LocalDate birthday = LocalDate.of(1995, Month.APRIL, 23); // Custom date

        System.out.println("Today: " + today);
        System.out.println("Birthday: " + birthday);

        // Adding/Subtracting days/months/years
        System.out.println("Next Week: " + today.plusWeeks(1));
        System.out.println("Last Month: " + today.minusMonths(1));

        // Compare two dates
        boolean isBefore = birthday.isBefore(today);
        System.out.println("Birthday before today? " + isBefore);

        // ---------------------------
        // 2. Working with LocalTime
        // ---------------------------
        LocalTime now = LocalTime.now();
        LocalTime meeting = LocalTime.of(14, 30); // 2:30 PM

        System.out.println("Current Time: " + now);
        System.out.println("Meeting Time: " + meeting);

        // Adding/Subtracting time
        System.out.println("After 2 hours: " + now.plusHours(2));

        // ---------------------------
        // 3. LocalDateTime (Date + Time)
        // ---------------------------
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + currentDateTime);

        LocalDateTime futureDateTime = currentDateTime.plusDays(5).plusHours(3);
        System.out.println("Future DateTime: " + futureDateTime);

        // ---------------------------
        // 4. ZonedDateTime (With Timezone)
        // ---------------------------
        ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime usTime = ZonedDateTime.now(ZoneId.of("America/New_York"));

        System.out.println("India Time: " + indiaTime);
        System.out.println("US Time: " + usTime);

        // ---------------------------
        // 5. Period (difference between dates)
        // ---------------------------
        Period age = Period.between(birthday, today);
        System.out.println("Age: " + age.getYears() + " years " +
                age.getMonths() + " months " +
                age.getDays() + " days");

        // ---------------------------
        // 6. Duration (difference between times)
        // ---------------------------
        Duration duration = Duration.between(meeting, now);
        System.out.println("Duration between meeting & now: " + duration.toMinutes() + " minutes");

        // ---------------------------
        // 7. Formatting & Parsing
        // ---------------------------
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formattedDate = currentDateTime.format(formatter);
        System.out.println("Formatted DateTime: " + formattedDate);

        // Parsing String to LocalDateTime
        String dateStr = "21-08-2025 19:30";
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateStr, formatter);
        System.out.println("Parsed DateTime: " + parsedDateTime);

        // ---------------------------
        // 8. Using ChronoUnit for calculations
        // ---------------------------
        long daysBetween = ChronoUnit.DAYS.between(birthday, today);
        System.out.println("Days since birthday: " + daysBetween);
    }
}
