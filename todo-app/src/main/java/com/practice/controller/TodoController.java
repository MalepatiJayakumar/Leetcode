package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dto.TodoDTO;
import com.practice.dto.UpdateDTO;
import com.practice.service.TodoService;

@RestController
@CrossOrigin("http://127.0.0.1:5500/")
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	TodoService todoService;

	@GetMapping("/get-all")
	public ResponseEntity<List<TodoDTO>> getAll() {
		List<TodoDTO> todoDtos = todoService.getAll();
		return new ResponseEntity<>(todoDtos, HttpStatus.OK);
	}
	/**
	public TodoDTO update(TodoDTO todo);
	public Integer delete(Integer id);
	public void saveAll(List<TodoDTO> todos);
	 */
	@PostMapping("/save")
	public void save(@RequestBody TodoDTO todoDTO) {
		System.out.println(todoDTO);
		todoService.save(todoDTO);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		todoService.delete(id);
	}
	
	@PutMapping("/status/{id}")
	public void update(@PathVariable Integer id, @RequestBody UpdateDTO updateDTO) {
		todoService.update(updateDTO,id);
	}

}
