package Views;

import Repositories.TodoListRepository;
import Services.TodoListServicesImpl;
import Services.TodoListServies;
import Entities.TodoList;
import java.util.Scanner;

public class TodoListTerminalViews implements TodoListViews {
    public static Scanner scanner = new Scanner(System.in);
    private final TodoListServies todoListServies;

    public TodoListTerminalViews(final TodoListServies todoListServies) {
        this.todoListServies = todoListServies;
    }
    public static String input(String info) {
        System.out.print(info + " : ");
        var data = scanner.nextLine();
        return data;
    }

    public void showTodoList() {
        System.out.println("TODO LIST");
        TodoList[] todos = todoListServies.getTodoList();
        for (var i = 0; i < todos.length; i++) {
            var todo = todos[i];
            if (todo != null) {
                System.out.println((i + 1) + ". " + todo.getTodo());
            }
        }
    }




    public void showMainMenu() {
        // infinite loop so the program will always run
        boolean isRunning = true;
        while (isRunning) {
            showTodoList();
            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Edit");
            System.out.println("4. Keluar");
            // input untuk menerima input dari user
            String selectedMenu = input("Pilih");

            switch (selectedMenu) {
                case "1":
                    showMenuAddTodoList();
                    break;
                case "2":
                    showMenuRemoveTodoList();
                    break;
                case "3":
                    showMenuEditTodoList();
                    break;
                case "4":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilih menu dengan benar");
            }
        }
    }
    public void showMenuAddTodoList() {
        System.out.println("MENAMBAH TODO LIST");
        var todo = input("Todo (x jika batal)");
        if (todo.equals("x")) {
            // batal
        } else {
            todoListServies.addTodoList(todo);
        }
    }
    public void showMenuRemoveTodoList() {
        System.out.println("MENGHAPUS TODO LIST");
        var number = input("Nomor yang dihapus (x jika batal)");
        if (number.equals("x")) {
            //batal
        } else {
            boolean success = todoListServies.removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus todo list : " + number);
            }
        }
    }
    public void showMenuEditTodoList() {
        System.out.println("MENGEDIT TODO LIST");
        String selectedTodo = input("Masukkan nomor todo (x jika batal)");
        if (selectedTodo.equals("x")) {
            return;
        }
        String newTodo = input("Masukkan todo yang baru (x jika batal)");
        if (newTodo.equals("x")) {
            return;
        }
        boolean isEditTodoSuccess = todoListServies.editTodoList(Integer.valueOf(selectedTodo), newTodo);
        if (isEditTodoSuccess) {
            System.out.println("Berhasil mengedit todo");
        } else {
            System.out.println("Gagal mengedit todo");
        }
    }


    @Override
    public void run() {
        showMainMenu();
    }
}
