package com.codingnotes.cong.business;

import com.codingnotes.cong.data.api.*;
import org.junit.Test;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockTest {

    @Test
    public void usingAMock() {
        // Given
        TodoService todoServiceMock = mock(TodoService.class);
        // Instead of creating a class to test a SUT (todoService interface in this
        // case), you can define test logic here
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        // When
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        // Then
        assertThat(filteredTodos.size(), is(0));
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
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
        // Then
        /*
         * This mock verify the deleteTodo was called to perform on argument "Learn to Dance" which does not contain
         * the word "Spring"
         */
        verify(todoServiceMock).deleteTodo("Learn to Dance");
    }


}
