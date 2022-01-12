package com.codingnotes.cong.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import com.codingnotes.cong.data.api.*;

public class TodoBusinessImplMockTest {

	@Test
	public void usingAMock() {
		TodoService todoServiceMock = mock(TodoService.class);
		// Instead of creating a class to test a SUT (todoService interface in this
		// case), you can define test logic here
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}

	// Compare using array instead of size
//	@Test
//	public void usingAStub2() {
//		TodoService todoService = new TodoServiceStub();
//		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
//		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");
//		String[] todoServiceArray = { "Learn Spring MVC", "Learn Spring" };
//		String[] filteredTodosArray = new String[filteredTodos.size()];
//		filteredTodos.toArray(filteredTodosArray);
//		assertArrayEquals(todoServiceArray, filteredTodosArray);
//	}
}
