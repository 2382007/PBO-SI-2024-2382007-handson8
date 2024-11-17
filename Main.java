import Repositories.TodoListRepository;
import Repositories.TodoListRepositoryImpl;
import Services.TodoListServicesImpl;
import Services.TodoListServies;
import Views.TodoListTerminalViews;
import Views.TodoListViews;
import config.Database;

public class Main {
    public static void main(String[] args) {
        Database database = new Database("databaseku", "root", "", "Localhost", "3306");
        database.setup();
//        TodoListRepository todoListRepository = new TodoListRepositoryImpl();

//        TodoListServies todoListService = new TodoListServicesImpl(todoListRepository);
//        TodoListViews todoListViews = new TodoListTerminalViews(todoListService);
//        todoListViews.run();
    }
}
