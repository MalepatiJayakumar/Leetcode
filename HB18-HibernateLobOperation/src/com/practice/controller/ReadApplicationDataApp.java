package com.practice.controller;

import java.io.FileOutputStream;
import java.io.FileWriter;

import org.hibernate.Session;

import com.practice.entity.ApplicantInfo;
import com.practice.utils.HibernateUtil;

public class ReadApplicationDataApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if(session != null) {
			try {
				ApplicantInfo application = session.get(ApplicantInfo.class, 1L);
				try(FileOutputStream fos = new FileOutputStream("C:\\Users\\malep\\Downloads\\applicantPhoto.jpg")){
					fos.write(application.getPhoto());
				}
				try(FileWriter fw = new FileWriter("C:\\Users\\malep\\Downloads\\applicantResume.txt")){
					fw.write(application.getResume());
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}