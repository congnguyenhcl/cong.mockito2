package com.codingnotes.cong.business;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

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

    @Test
    public void usingAMock2() {

        // Given
        TodoService todoServiceMock = mock(TodoService.class);
        // Instead of creating a class to test a SUT (todoService interface in this
        // case), you can define test logic here
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        // When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Learn to Dance");
        // Then
        /*
         * This mock verify the deleteTodo was called to perform on argument "Learn to Dance" which does not contain
         * the word "Spring"
         */
        verify(todoServiceMock).deleteTodo("Learn to Dance");
    }


}
