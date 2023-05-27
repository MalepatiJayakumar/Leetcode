package com.practice.Interfaces;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

//class MyPredicate implements Predicate<Integer>{
//
//	@Override
//	public boolean test(Integer i) {
//		if(i>0) {
//			return true;
//		}
//		return false;
//	}
//	
//}

public class TestPredicates1 {

	public static void main(String[] args) {

//		MyPredicate predicate= new MyPredicate();
//		
//		int[] sourceArray = {1,2,-1,-6,0,10,04};
//		
//		//we need only values greater than 10
//		List<Integer> list = new ArrayList<>(); 
//		
//		for(int i : sourceArray) {
//			if(predicate.test(i)) {
//				list.add(i);
//			}
//		}
//		
//		System.out.println(list);
//		

		Task task = new Task();
		Predicate<Task> closePredicate = i -> i.getName() != null && i.getId() != null && i.getProcessorId() != null
				&& i.getStatus() != null;
		testPredicates(closePredicate, Arrays.asList(task));

		Predicate<Task> JETask = i -> i.getApproverId() != null;
		testPredicates(closePredicate.and(JETask), Arrays.asList(task));

		Project p = new Project();
//		p.setName("Test_May");
		Predicate<Project> project = i -> i.getName() != null;
		List<Project> output = testPredicates(project, Arrays.asList(p));
		System.out.println(output);
	}

	private static <T> List<T> testPredicates(Predicate<T> closePredicate, List<T> t) {
		List<T> filteredData = new ArrayList<>();
		for (T t1 : t) {
			if (closePredicate.test(t1)) {
				filteredData.add(t1);
			} else {
				System.out.println("Failed for mandatory checks");
			}
		}
		return filteredData;
	}
}

class Project {
	private Long id;
	private String name;
	private String fiscalYear;
	private String period;
	private String status;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

class Task {
	private Integer id;
	private String name;
	private Long processorId;
	private Long reviewerId;
	private Long approverId;
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getProcessorId() {
		return processorId;
	}

	public void setProcessorId(Long processorId) {
		this.processorId = processorId;
	}

	public Long getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(Long reviewerId) {
		this.reviewerId = reviewerId;
	}

	public Long getApproverId() {
		return approverId;
	}

	public void setApproverId(Long approverId) {
		this.approverId = approverId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}