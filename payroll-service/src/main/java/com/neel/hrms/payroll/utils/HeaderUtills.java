package com.neel.hrms.payroll.utils;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class HeaderUtills {
	
	private final Keys keys;

	public String[] getHeader(String headerName) {
		if(headerName.equals("BiometricCsvHeader"))
			return keys.getBiometricCsvHeader();
		return null;
	}

}
