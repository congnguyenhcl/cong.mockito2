package com.codingnotes.cong.business;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class ListTest {
    /* Test written using BDD or Behavior Driven Development style
     *  Notice instead of using when...thenReturn, given...willReturn is used
     *  Instead of assertEquals(expected, acdtual), assertThat(actual, matcher) is used
     *  BDD helps test writing more readable.
     *
     */
    @Test
    public void mockListUsingMethod() {
        // Given - Setup
        List listMock = mock(List.class);
        // When
        given(listMock.size()).willReturn(2);
        // Then
        assertThat(listMock.size(), is(2));
        assertThat(listMock.size(), is(2));
        assertThat(listMock.size(), is(2));
    }

    @Test
    /*
    Whenever size() method is called, 1st returns 2 then return 3 and then 3 indefinitely
     */ public void mockListUsingMethod_ReturnMultipleValues() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
        assertEquals(3, listMock.size());
    }

    /*
    This is  mocking using Matchers' methods. Here anyInt is used, but we can use any others such as anyDouble, etc...
    Whenever get(index) method of List is called, regardless of the index position, 1st return 2, then 3 and 3 forever
     */
    @Test
    public void mockListUsingMatcher() {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenReturn(2).thenReturn(3);
        assertEquals(2, listMock.get(0));
        assertEquals(3, listMock.get(1));
    }

    @Test(expected = RuntimeException.class)
    public void mockException() {
        List listMock = mock(List.class);
        // Argument Matcher
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
        /* Running get(index) will generate a runtime exception. We annotate the expected return is a runtime
         * exception after @Test. This is how Mockito knows how to evaluate the test outcome
         */

        listMock.get(20);
    }

}
