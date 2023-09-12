package com.practice.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.ApplicantInfo;
import com.practice.utils.HibernateUtil;

public class AddApplicationInfoApp {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if(session != null) {
			Transaction transaction = null;
			Long id = null;
			try {
				transaction = session.beginTransaction();
				ApplicantInfo applicant = new ApplicantInfo();
				applicant.setName("Jaikumar");
				applicant.setAddress("HYD");
				File file = new File("C:\\Users\\malep\\Downloads\\testResume.txt");
				try (FileInputStream fos = new FileInputStream("C:\\Users\\malep\\Downloads\\photo.jpg");
						FileReader fr = new FileReader(file)) {
					byte[] photo = new byte[fos.available()];
					fos.read(photo);
					
					char[] resume = new char[(int)file.length()];
					fr.read(resume);
					
					applicant.setPhoto(photo);
					applicant.setResume(resume);
				}
				id = (Long) session.save(applicant);
				System.out.println("Application has been submitted with id :: "+id);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				transaction.commit();
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}