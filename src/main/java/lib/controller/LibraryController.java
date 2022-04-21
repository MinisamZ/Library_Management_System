package lib.controller;

import lib.model.Book;
import lib.model.LogEntry;
import lib.model.User;
import lib.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {
    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/list-of-user")
    // список пользователей
    public List<User> getListUsers() {
        return libraryService.findAllUsers();
    }

    @GetMapping("/list-of-books")
    // список книг
    public List<Book> getListBooks() {
//        String s = "";
//        List<Book> books = libraryService.findAllBooks();
//        for (Book b : books) {
//            s += b.toBString();
//        }
        return libraryService.findAllBooks();
    }

    @GetMapping("/listBbooks")
    // список книг отданных и возвращенных
    public String getListHistoryOfBookTaking() {
        List<LogEntry> logEntries = libraryService.getAllLogEntry();
        String s = "";
        for (LogEntry logEntry : logEntries) {
            s += "LogEntry{" + "id=" + logEntry.getId() + ", idBook=" + libraryService.getBookById(logEntry.getIdBook()) + ", idName=" + libraryService.getUserById(logEntry.getIdUser()) + ", returned=" + logEntry.getReturned() + ", date='" + logEntry.getDate() + '\'' + "}\n";
        }
        return s;
    }

    @GetMapping("/ListOfBorrowedBooks/{returned}")
    public String getListOfBorrowedBooks(@PathVariable("returned") boolean returned) {
        // список возвращенных и не возвращенных книг
        List<LogEntry> logEntries = libraryService.getListReturnedBooks(returned);
        String s = "";
        for (LogEntry logEntry : logEntries) {
            s += "LogEntry{" + "id=" + logEntry.getId() +
                    ", idBook=" + libraryService.getBookById(logEntry.getIdBook()) +
                    ", idName=" + libraryService.getUserById(logEntry.getIdUser()) +
                    ", returned=" + logEntry.getReturned() +
                    ", date='" + logEntry.getDate() + '\'' + "}\n";
        }
        return s;
    }

    @GetMapping("/ListOfBorrowedBooksStudent/{id}")
    public String getListOfBorrowedBooksStudent(@PathVariable("id") Long id) {
        // история взятых книг у определенного студента
        List<LogEntry> logEntries = libraryService.getEntryByStudentId(id);
        List<Book> books = new ArrayList<>();
        for (LogEntry logEntry : logEntries) {
            books.add(libraryService.getBookById(logEntry.getIdBook()));
        }
        return books.toString();
    }

    @GetMapping("/ListOfBorrowedBooksStudent/{id}/{returned}")
    public String getListListOfReturnedBooksOrNot(@PathVariable("id") Long id, @PathVariable("returned") boolean returned) {
        // история взятых книг у определенного студента с фильтром на возврат
        List<LogEntry> logEntries = libraryService.getEntryByStudentIdAndReturned(id,returned);
        List<Book> books = new ArrayList<>();
        for (LogEntry logEntry : logEntries) {
            books.add(libraryService.getBookById(logEntry.getIdBook()));
        }
        return books.toString();
    }

    @PostMapping("/user-create")
    public User createUser(User user) {
        System.out.println(user.toString());
//        libraryService.saveUser(user);
        return libraryService.saveUser(user);
    }



}
