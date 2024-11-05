package Services;

import Entities.TodoList;

public interface TodoListServies {
    TodoList[] getTodoList();
    void addTodoList(String todo);
    Boolean removeTodoList(Integer number);
    Boolean editTodoList(Integer number, String todo);
}
