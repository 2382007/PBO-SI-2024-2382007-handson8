import Entities.TodoList;
import Repositories.TodoListRepository;
import Repositories.TodoListRepositoryImpl;
import Services.TodoListServicesImpl;
import Services.TodoListServies;
import Views.TodoListTerminalViews;
import Views.TodoListViews;

public class Main {
    public static void main(String[] args) {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListServies todoListService = new TodoListServicesImpl(todoListRepository);
        TodoListViews todoListViews = new TodoListTerminalViews(todoListService);
        todoListViews.run();
    }
}
