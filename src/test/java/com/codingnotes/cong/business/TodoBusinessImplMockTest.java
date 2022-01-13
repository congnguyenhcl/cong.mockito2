package com.codingnotes.cong.business;

import com.codingnotes.cong.data.api.*;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
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
        assertThat(filteredTodos.size(), is(2));
    }

    @Test
    public void deleteTodoMethodTest() {

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
        // Verify deleteToDo() is called w/ an arg
        verify(todoServiceMock).deleteTodo("Learn to Dance");
        // Using Mockito BDD style to make unit testing code more readable
        then(todoServiceMock).should().deleteTodo("Learn to Dance");
        // Verify deleteToDo() is never called
        then(todoServiceMock).should(never()).deleteTodo("Dummy");
        verify(todoServiceMock, never()).deleteTodo("Dummy");

    }

    @Test
    public void argCaptureTest() {
        // Declare arg captor
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
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
         * This mock evaluates the arg passed into method deleteTodo with the expected arg that would have been
         * Because the string "Learn to Dance" does not contain "spring", deleteTodo() would be executed using it
         * as an arg. Hence, assertThat would evaluate to true.
         */
        then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));


    }

}
