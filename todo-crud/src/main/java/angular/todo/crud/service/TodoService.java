package angular.todo.crud.service;

import angular.todo.crud.entity.Todo;
import angular.todo.crud.respository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository repository;

    public Todo saveTodo(Todo todo) {
        return repository.save(todo);
    }

    public List<Todo> saveTodos(List<Todo> todos) {
        return repository.saveAll(todos);
    }

    public List<Todo> getTodos() {
        return repository.findAll();
    }

    public Todo getTodoById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Todo> getTodoByIsCompleted(int IsCompleted) {
        return repository.findAllByIsCompleted(IsCompleted);
    }

    public Todo getTodoByContent(String Content) {
        return repository.findByContent(Content);
    }

    public String deleteTodo(int id) {
        repository.deleteById(id);
        return "Todo removed !! " + id;
    }

    public Todo updateTodo(Todo todo) {
        Todo existingTodo = repository.findById(todo.getId()).orElse(null);
        existingTodo.setContent(todo.getContent());
        existingTodo.setIsCompleted(todo.getIsCompleted());
        return repository.save(existingTodo);
    }
    public Todo updateStatus(Todo todo) {
        Todo existingTodo = repository.findById(todo.getId()).orElse(null);
        existingTodo.setIsCompleted(todo.getIsCompleted());
        return repository.save(existingTodo);
    }
}
