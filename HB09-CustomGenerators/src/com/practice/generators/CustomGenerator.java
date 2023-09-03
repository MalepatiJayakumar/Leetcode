package com.practice.generators;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.practice.controller.AlphaNumericGenerator;

public class CustomGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		System.out.println("CustomGenerator.generate()");
		AlphaNumericGenerator alphaNumeric = new AlphaNumericGenerator();
		return "JAI-01";
	}
}