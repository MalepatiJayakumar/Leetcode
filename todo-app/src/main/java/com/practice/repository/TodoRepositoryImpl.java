package com.practice.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.dto.UpdateDTO;
import com.practice.entity.Todo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TodoRepositoryImpl implements TodoRepository {

	@Autowired
	EntityManager entityManager;

	@Override
	public void save(Todo todo) {
		entityManager.persist(todo);
	}

	@Override
	public void update(UpdateDTO updateDTO, Integer id) {
		 entityManager.createNativeQuery("update Todo t set t.is_completed = :completed where t.id = :id ", Todo.class)
				.setParameter("id", id).setParameter("completed", updateDTO.isCompleted()).executeUpdate();
	}

	@Override
	public Integer delete(Integer id) {
		entityManager.createQuery("delete from Todo where id = :id ", Todo.class).setParameter("id", id)
				.executeUpdate();
		return id;
	}

	@Override
	public void saveAll(List<Todo> todos) {
		for (Todo todo : todos) {
			entityManager.persist(todo);
		}
	}

	@Override
	public List<Todo> getAll() {
		return entityManager.createQuery("from Todo", Todo.class).getResultList();
	}

}
