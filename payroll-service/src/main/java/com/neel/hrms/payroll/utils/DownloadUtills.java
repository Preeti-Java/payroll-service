package com.neel.hrms.payroll.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.neel.hrms.payroll.exception.CsvException;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DownloadUtills {
	
	private final HeaderUtills headerUtills;
	
	private static final String PATH_C_RESOURCE = "C:/Resources/";
	
	public void generateCsvTemplate(String param, HttpServletResponse response) {
	    String path = PATH_C_RESOURCE;
	    File dir = new File(path);

	    if (!dir.exists() && !dir.mkdir()) {
	        // Handle the case where the directory creation fails
	        throw new CsvException("Failed to create directory: " + path);
	    }

	    File csvTemplate = new File(dir, param + "_Template.csv");

	    // get header of csv for match
	    String[] csvHeader = headerUtills.getHeader(param);

	    try {
	        String data = String.join(",", csvHeader);

	        if (csvTemplate.exists() && !csvTemplate.delete()) {
	            // Handle the case where the file deletion fails
	            throw new CsvException("Failed to delete existing file: " + csvTemplate.getAbsolutePath());
	        }

	        try (FileWriter fileWriter = new FileWriter(csvTemplate)) {
	            fileWriter.write(data);
	            // no need to flush, the try-with-resources will take care of it
	        }

	        downloadFile(path, param + "_Template.csv", response, false);
	    } catch (IOException e) {
	        // Handle the exception appropriately, log or rethrow as needed
	        e.printStackTrace();
	    }
	}
	
	public void downloadFile(String fileLocation, String fileName, HttpServletResponse response, boolean waterFlage)
			throws IOException {

		File file = new File(fileLocation + fileName);;
		try(
			FileInputStream fin = new FileInputStream(file);
			BufferedInputStream bin = new BufferedInputStream(fin);
			ServletOutputStream sos = response.getOutputStream()
				) {
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			response.setHeader("Pragma", "public");
			response.setHeader("Cache-Control", "max-age=-1");
			response.setContentLengthLong(file.length());
			byte[] buff = new byte[8192];
			int numChars;
			while ((numChars = bin.read(buff, 0, buff.length)) != -1)
				sos.write(buff, 0, numChars);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
