package Services;

import Entities.TodoList;
import Repositories.TodoListRepository;
import Repositories.TodoListRepositoryImpl;

public class TodoListServicesImpl implements TodoListServies {
private final TodoListRepository todoListRepository;

    public TodoListServicesImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public TodoList[] getTodoList() {
        return todoListRepository.getAll();
    }

    @Override
    public void addTodoList(String todo) {
        if (todo.isEmpty() || todo.isBlank()) {
            System.out.println("Masukkan todo dengan benar");
            return;
        }

        TodoList todoList = new TodoList();
        todoList.setTodo(todo);
        todoListRepository.add(todoList);
    }

    @Override
    public Boolean removeTodoList(Integer number) {
        return todoListRepository.remove(number);
    }

    @Override
    public Boolean editTodoList(final Integer number, final String todo) {
        TodoList todoList = new TodoList();
        todoList.setTodo(todo);
        todoList.setId(number);
        return todoListRepository.edit(todoList);
    }
}
