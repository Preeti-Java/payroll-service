package com.neel.hrms.payroll.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class HolidayAndSundayCalculator {
	 public static void main(String[] args) {
	        // Define the date range
	        LocalDate startDate = LocalDate.of(2023, 12, 1);
	        LocalDate endDate = LocalDate.of(2023, 12, 30);

	        
	        int year = 2023; // Replace with the desired year
	        Month month = Month.DECEMBER; // Replace with the desired month

	        // List of holidays (add your specific holidays)
	        List<LocalDate> holidays = fetchHolidays(year, month);
	                // Add more holidays as needed

	        // Calculate holidays and Sundays
	        long holidayCount = calculateHolidays(startDate, endDate, holidays);
	        long sundayCount = calculateSundays(startDate, endDate);

	        // Display the results
	        System.out.println("Number of holidays: " + holidayCount);
	        System.out.println("Number of Sundays: " + sundayCount);
	    }

	 private static List<LocalDate> fetchHolidays(int year, Month month) {
	        try {
	            // Replace the URL with the actual URL of the holiday API
	            String apiUrl = "https://api.example.com/holidays?year=" + year + "&month=" + month.getValue();
	            URL url = new URL(apiUrl);

	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("GET");

	            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String line;
	            StringBuilder response = new StringBuilder();

	            while ((line = reader.readLine()) != null) {
	                response.append(line);
	            }
	            reader.close();

	            // Parse the response to get a list of LocalDate objects representing holidays
	            // This depends on the format of the API response
	            return parseApiResponse(response.toString());
	        } catch (Exception e) {
	            e.printStackTrace();
	            // Handle exceptions appropriately
	            return List.of();
	        }
	    }

	    private static List<LocalDate> parseApiResponse(String apiResponse) {
	        // Implement the parsing logic based on the format of the API response
	        // For example, if the response is in JSON format, you can use a JSON parser
	        // to extract the holiday dates.
	        // Return a list of LocalDate objects representing holidays.
	        // This is a placeholder method, and you need to adapt it based on your actual API response format.
	        // For simplicity, this example assumes a comma-separated list of dates.
	        return List.of(apiResponse.split(","))
	                .stream()
	                .map(LocalDate::parse)
	                .collect(Collectors.toList());
	    }

		private static long calculateHolidays(LocalDate startDate, LocalDate endDate, List<LocalDate> holidays) {
	        return startDate.datesUntil(endDate.plusDays(1))
	                .filter(date -> holidays.contains(date) || date.getDayOfWeek() == DayOfWeek.SUNDAY)
	                .count();
	    }

	    private static long calculateSundays(LocalDate startDate, LocalDate endDate) {
	        return startDate.datesUntil(endDate.plusDays(1))
	                .filter(date -> date.getDayOfWeek() == DayOfWeek.SUNDAY)
	                .count();
	    }
}
