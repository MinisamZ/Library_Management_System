package lib.controller;

import lib.model.Book;
import lib.model.User;
import lib.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibraryController {
    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/list-of-user")
    public List<User> getListUsers() {
        return libraryService.findAllUsers();
    }

    @GetMapping("/list-of-books")
    public List<Book> getListBooks() {
//        String s = "";
//        List<Book> books = libraryService.findAllBooks();
//        for (Book b : books) {
//            s += b.toBString();
//        }
        return libraryService.findAllBooks();
    }

    @GetMapping("/listBbooks")
    public String getListHistoryOfBookTaking(){

        return "1";
    }


}
