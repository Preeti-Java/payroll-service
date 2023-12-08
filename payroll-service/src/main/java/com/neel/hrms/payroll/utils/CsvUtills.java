package com.neel.hrms.payroll.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.neel.hrms.payroll.exception.CsvException;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CsvUtills {
	
	private final HeaderUtills headerUtills;

	public boolean checkSalaryCsv(MultipartFile csv,HttpServletRequest request) throws IOException {
		
		if(csv.getOriginalFilename() == null && csv.getOriginalFilename().indexOf("csv") == -1)
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
			String[] data = line.split(",");
			if (data.length != headers.length) 
				throw new CsvException("Invalid CSV Headers");
			 else {
				if (data.length == headers.length &&  (countLine == 0)) {
						for (int i = 0; i < headers.length; i++) {
							if (!headers[i].trim().equalsIgnoreCase(data[i].trim())) {
								throw new CsvException("\tInvalid Header " + data[i].trim() + ". It should be as "
										+ headers[i].trim() + ".\n");
							}
						}
					}
				} 
				countLine++;
		}
		if (!flage.equals("Success")) 
		{
			createFailedFileCSV(errors,request);
			return false;
		}
		return true;
	}

	void createFailedFileCSV(StringBuilder errors, HttpServletRequest request) throws IOException {
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		arrayOutputStream.write(errors.toString().getBytes());
		request.getSession(true).setAttribute("csvErrFile", arrayOutputStream);
	}


}
