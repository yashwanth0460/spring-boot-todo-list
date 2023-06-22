/*
 * You can use the following import statements
 * 
 * import org.springframework.web.server.ResponseStatusException;
 * import org.springframework.http.HttpStatus;
 * 
 */

package com.example.todo;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import com.example.todo.Todo;
import com.example.todo.TodoRepository;
import java.util.*;

// Do not modify the below code

public class TodoService implements TodoRepository {

    private static HashMap<Integer, Todo> todoList = new HashMap<>();

    public TodoService() {
        todoList.put(1, new Todo(1, "Watch Movie", "LOW", "TO DO"));
        todoList.put(2, new Todo(2, "Finish Project", "HIGH", "IN PROGRESS"));
        todoList.put(3, new Todo(3, "Buy Groceries", "MEDIUM", "TO DO"));
        todoList.put(4, new Todo(4, "Learning from NxtWave", "HIGH", "IN PROGRESS"));
        todoList.put(5, new Todo(5, "Go for a Run", "MEDIUM", "DONE"));

    }

    // Do not modify the above code

    // Write your code here
    int uniqueId = 6;
    @Override
    public Todo addTodo(Todo toDo) {
        toDo.setId(uniqueId);
        todoList.put(uniqueId,toDo);
        uniqueId += 1;
        return toDo;
    }

    @Override
    public ArrayList<Todo> getTodos() {
        Collection<Todo> toDoCollection = todoList.values();
        ArrayList<Todo> todos = new ArrayList<Todo>(toDoCollection);
        return todos;
    }

    @Override
    public Todo getTodoById(int id) {
        Todo toDo = todoList.get(id);
        if (toDo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return toDo;
    }

    @Override
    public Todo updateTodo(int id, Todo toDo) {
        Todo existingtTodo = todoList.get(id);

        if (existingtTodo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (toDo.getTodo() != null) {
            existingtTodo.setTodo(toDo.getTodo());
        }

        if (toDo.getPriority() != null) {
            existingtTodo.setPriority(toDo.getPriority());
        }

        if (toDo.getStatus() != null) {
            existingtTodo.setStatus(toDo.getStatus());
        }
        
        todoList.put(id,existingtTodo);
        return existingtTodo;
    }

    @Override
    public void deleteTodo(int id) {
        Todo toDo = todoList.get(id);

        if (toDo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            todoList.remove(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
