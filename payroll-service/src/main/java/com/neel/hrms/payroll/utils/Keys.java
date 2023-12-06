package com.neel.hrms.payroll.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("keys")
public class Keys {

	@Value("#{'${BiometricCsvHeader}'.split(',')}")
	private String[] biometricCsvHeader;

	public String[] getBiometricCsvHeader() {
		return biometricCsvHeader;
	}

	public void setBiometricCsvHeader(String[] biometricCsvHeader) {
		this.biometricCsvHeader = biometricCsvHeader;
	}

}