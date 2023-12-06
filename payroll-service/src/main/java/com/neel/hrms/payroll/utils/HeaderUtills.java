package com.neel.hrms.payroll.utils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HeaderUtills {
	
	private final Keys keys;

	public String[] getHeader(String headerName) {
		if(headerName.equals("BiometricCsvHeader"))
			keys.getBiometricCsvHeader();
		return null;
	}

}
