/*
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.todo;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.todo.Todo;
import com.example.todo.TodoService;

@RestController
public class TodoController {

    TodoService todoService = new TodoService();

    @DeleteMapping("/todos/{id}")
    public void deleteMovie(@PathVariable("id") int id) {
        todoService.deleteTodo(id);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable("id") int id,@RequestBody Todo toDo) {
        return todoService.updateTodo(id, toDo);
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo toDo) {
        return todoService.addTodo(toDo);
    }

    @GetMapping("/todos")
    public ArrayList<Todo> getTodos() {
        return todoService.getTodos();
    }

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable("id") int id) {
        return todoService.getTodoById(id);
    }
}