package com.practice.service;

import java.util.List;

import com.practice.dto.TodoDTO;
import com.practice.dto.UpdateDTO;

public interface TodoService {

	public void save(TodoDTO todo);

	public void update(UpdateDTO updateDTO, Integer id);

	public Integer delete(Integer id);

	public void saveAll(List<TodoDTO> todos);

	public List<TodoDTO> getAll();
}
