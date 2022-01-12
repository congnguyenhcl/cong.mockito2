package com.codingnotes.cong.business;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;
import com.codingnotes.cong.data.api.*;

public class TodoBusinessImplStubTest {

	@Test
	public void usingAStub() {
		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(2, todos.size());
	}
	// Compare using array instead of size
	@Test
	public void usingAStub2() {
		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");
		String[] todoServiceArray = {"Learn Spring MVC", "Learn Spring"};
		String[] filteredTodosArray = new String[filteredTodos.size()];		
		filteredTodos.toArray(filteredTodosArray);
		assertArrayEquals(todoServiceArray, filteredTodosArray);
	}
}
