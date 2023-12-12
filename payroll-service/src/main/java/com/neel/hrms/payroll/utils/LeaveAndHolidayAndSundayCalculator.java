package com.neel.hrms.payroll.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;


@Component
public class LeaveAndHolidayAndSundayCalculator {
	

	 public static List<LocalDate> fetchHolidays() {
	        try {

	            StringBuilder response = new StringBuilder();
	           String list = "2023-03-08,2023-03-30,2023-04-04,2023-04-07,2023-04-22,2023-05-05,2023-06-29,2023-07-29,2023-08-15,2023-09-07,2023-09-28,2023-10-02,2023-10-24,2023-11-12,2023-11-27,2023-12-25";
												
	            response.append(list);

	            // Parse the response to get a list of LocalDate objects representing holidays
	            // This depends on the format of the API response
	            return parseApiResponse(response.toString());
	        } catch (Exception e) {
	            e.printStackTrace();
	            // Handle exceptions appropriately
	            return List.of();
	        }
	    }

	 public static List<LocalDate> parseApiResponse(String apiResponse) {
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
	    
	   

	 public static long calculateHolidays(LocalDate startDate, LocalDate endDate, List<LocalDate> holidays) {
	        return startDate.datesUntil(endDate.plusDays(1))
	                .filter(holidays::contains)
	                .count();
	    }

	 public static long calculateSundays(LocalDate startDate, LocalDate endDate) {
	        return startDate.datesUntil(endDate.plusDays(1))
	                .filter(date -> date.getDayOfWeek() == DayOfWeek.SUNDAY)
	                .count();
	    }

	public static long calculateLeaves(LocalDate startDate, LocalDate endDate, long totalPresentDay, long holidaysAndSundays) {
		int daysOfMonth = endDate.getDayOfMonth() + 1 - startDate.getDayOfMonth() ;
		return daysOfMonth - holidaysAndSundays - totalPresentDay;
	}
}
