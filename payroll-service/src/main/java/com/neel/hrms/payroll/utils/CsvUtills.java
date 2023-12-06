package com.neel.hrms.payroll.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.neel.hrms.payroll.exception.CsvException;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CsvUtills {
	
	private final HeaderUtills headerUtills;

	public boolean checkSalaryCsv(MultipartFile csv) {
		
		if(csv.getOriginalFilename().indexOf("csv") == -1)
			throw new CsvException("Select a valid csv file.");
		
		//get header of csv for match
		String[] headers= headerUtills.getHeader("BiometricCsvHeader");
		if(headers.length == 0)
			throw new CsvException("Headers not present in properties file");
		// For Hindi Support
		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(csv.getBytes()), "UTF8");
		BufferedReader csvReader = new BufferedReader(isr);
		StringBuilder errors = new StringBuilder("");
		String flage = "Success";
		String line = "";
		int countLine = 0;
		
		
		while ((line = csvReader.readLine()) != null) {
			if (headers == null) {
				throw new CsvException("CSV is empty");
			}
			String[] data = line.split(",");
			if (data.length != headers.length) {
				throw new CsvException("Invalid CSV Headers");

			} else {
				if (data.length == headers.length) {
					if (countLine == 0) {
						for (int i = 0; i < headers.length; i++) {
							if (!headers[i].trim().equalsIgnoreCase(data[i].trim())) {
								throw new CsvException("\tInvalid Header " + data[i].trim() + ". It should be as "
										+ headers[i].trim() + ".\n");
							}
						}
					} else if (countLine > 0) {
							try {
								
							} catch (Exception e) {
								flage = "Failed";
								errors.append("\tSomething wrong in data Please check  . Line No.:" + countLine
										+ " and File Id:-" + data[1].trim() + "\n");
								countLine++;
								continue;

							}

						}
					}

				} 
				countLine++;

		}
		if (!flage.equals("Success")) 
		{
			createFailedFileCSV(errors, request, invalidLine);
			errorFile = "Failed";
		}
		
		return false;
	}

}
