package com.codingnotes.cong.business;

import java.util.ArrayList;
import java.util.List;
import com.codingnotes.cong.data.api.*;
// TodoBusinessImpl is System Under Test
// todoService is a dependency
public class TodoBusinessImpl {
	private final TodoService todoService;

	TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}

	public List<String> retrieveTodosRelatedToSpring(String todo) {
		List<String> filteredTodos = new ArrayList<>();
		List<String> allTodos = todoService.retrieveTodos(todo);
		for (String tempTodo : allTodos) {
			if (tempTodo.contains("Spring")) {
				filteredTodos.add(tempTodo);
			}
		}
		return filteredTodos;
	}
    public void deleteTodosNotRelatedToSpring(String todo) {
        List<String> allTodos = todoService.retrieveTodos(todo);
        for (String tempTodo : allTodos) {
            if (!tempTodo.contains("Spring")) {
                todoService.deleteTodo(tempTodo);
            }
        }
    }

}