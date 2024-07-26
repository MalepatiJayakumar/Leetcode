package com.practice.runners;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.practice.entity.Todo;
import com.practice.repository.TodoRepository;

@Configuration
public class TestRunner implements CommandLineRunner {

	@Autowired
	TodoRepository todoRepository;

	@Override
	public void run(String... args) throws Exception {
		Todo todo = new Todo("test", new Date(),false);
		Todo todo1 = new Todo("test1", new Date(),false);
		Todo todo2 = new Todo("test2", new Date(),false);
		Todo todo3 = new Todo("test3", new Date(),false);
		Todo todo4 = new Todo("test4", new Date(),false);
		Todo todo5 = new Todo("test5", new Date(),false);
		todoRepository.saveAll(List.of(todo,todo1,todo2,todo3,todo4,todo5));
		
		for(Todo t : todoRepository.getAll()) {
			System.out.println(t);
		}
		
		todo.setCompleted(false);
		todo1.setCompleted(true);
//		todoRepository.update(todo);
//		todoRepository.update(todo1);
		
		for(Todo t : todoRepository.getAll()) {
			System.out.println(t);
		}
		
	}

}
