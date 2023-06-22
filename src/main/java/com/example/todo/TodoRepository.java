// Write your code here
package com.example.todo;

import java.util.ArrayList;

public interface TodoRepository {
    ArrayList<Todo> getTodos();
    Todo getTodoById(int id);
    Todo addTodo(Todo toDo);
    Todo updateTodo(int id, Todo toDo);
    void deleteTodo(int id);
    
}