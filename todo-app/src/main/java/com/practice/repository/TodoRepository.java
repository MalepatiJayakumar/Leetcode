package com.practice.repository;

import java.util.List;

import com.practice.dto.UpdateDTO;
import com.practice.entity.Todo;

public interface TodoRepository {

	public void save(Todo todo);
	
	public void update(UpdateDTO updateDTO, Integer id);
	
	public Integer delete(Integer id);
	
	public void saveAll(List<Todo> todos);
	
	public List<Todo> getAll();
	
}