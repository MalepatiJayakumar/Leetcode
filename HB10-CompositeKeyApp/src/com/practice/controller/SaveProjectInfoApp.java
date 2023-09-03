package com.practice.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entity.ProjectId;
import com.practice.entity.ProjectInfo;
import com.practice.utils.HibernateUtil;

public class SaveProjectInfoApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		ProjectId output = null;
		if(session != null) {
			Transaction transaction = session.beginTransaction();
			try {
				ProjectId pId = new ProjectId();
				pId.setId(1);
				pId.setDeptNo(501);
				
				ProjectInfo projectInfo = new ProjectInfo();
				projectInfo.setProjectId(pId);
				projectInfo.setpName("JaiKumar");
				projectInfo.setpDept("Product Development");
				output = (ProjectId)session.save(projectInfo);
				System.out.println("Saved id :: "+output);
			}catch(Exception e) {
				System.out.println("Exception occurred while saving project info :: "+e);
			}finally {
				transaction.commit();
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}	