package com.practice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dto.TodoDTO;
import com.practice.dto.UpdateDTO;
import com.practice.entity.Todo;
import com.practice.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoRepository todoRepository;

	@Override
	public void save(TodoDTO todoDTO) {
		Todo todo = new Todo();
		BeanUtils.copyProperties(todoDTO, todo);
		todoRepository.save(todo);
	}

	@Override
	public void update(UpdateDTO updateDTO, Integer id) {
		 todoRepository.update(updateDTO,id);
		
	}

	@Override
	public Integer delete(Integer id) {
		return todoRepository.delete(id);
	}

	@Override
	public void saveAll(List<TodoDTO> todos) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TodoDTO> getAll() {
		List<Todo> todos = todoRepository.getAll();
		List<TodoDTO> todoDtos = new ArrayList<>();
		for (Todo t : todos) {
			TodoDTO todoDTO = new TodoDTO();
			BeanUtils.copyProperties(t, todoDTO);
			todoDtos.add(todoDTO);
		}
		return todoDtos;
	}

}