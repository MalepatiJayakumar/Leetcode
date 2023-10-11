package com.practice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zaxxer.hikari.HikariDataSource;

@Repository
public class InsurancePolicyDAO {

	private static final String REALTIMEDI_CUSTOMER_INSERT_QUERY = "INSERT INTO insurancepolicy(`policyNo`,`policyName`,`companyName`,`holderName`,`tenure`) VALUE(?,?,?,?,?)";

	@Autowired
	private HikariDataSource dataSource;
	
	static {
		System.out.println("InsurancePolicyDAO.class file is loading");
	}
	
	public InsurancePolicyDAO() {
		System.out.println("InsurancePolicyDAO.InsurancePolicyDAO()");
	}

	public Integer saveInsurancePolicy() {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(REALTIMEDI_CUSTOMER_INSERT_QUERY)) {
			pstmt.setInt(1, 6);
			pstmt.setString(2, "Jeevan");
			pstmt.setString(3, "HDFC");
			pstmt.setString(4, "Dhanush");
			pstmt.setInt(5, 20);
			
			Integer count =  pstmt.executeUpdate();
			System.out.println(count);
			connection.close();
			return count;
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("failed");
		return 0;
	}
}