package com.practice.controller;

import org.hibernate.Session;

import com.practice.entity.ProjectId;
import com.practice.entity.ProjectInfo;
import com.practice.utils.HibernateUtil;

public class SelectProjectInfo {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		if(session != null) {
			ProjectId projectId = new ProjectId();
			projectId.setId(1);
			projectId.setDeptNo(501);
			ProjectInfo info = session.get(ProjectInfo.class,projectId);
			if(info != null) {
				System.out.println(info);
			}else {
				System.out.println("Record Not found with provided information");
			}
			HibernateUtil.closeSession();
			HibernateUtil.closeSessionFactory();
		}
	}
}