package com.practice.controller;

import com.practice.dao.ITransferData;
import com.practice.dao.TransferDataImpl;

public class TestApp {
	public static void main(String[] args) {
		ITransferData transferData = new TransferDataImpl();
		System.out.println(transferData.transferInsuranceData(1L));
	}
}