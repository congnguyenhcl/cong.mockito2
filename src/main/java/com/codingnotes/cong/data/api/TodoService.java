package com.codingnotes.cong.data.api;

import java.util.List;

//External Service - Lets say this comes from WunderList
public interface TodoService {
    List<String> retrieveTodos(String todo);

    void deleteTodo(String todo);
}