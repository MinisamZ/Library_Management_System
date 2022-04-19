package lib.controller;

import lib.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {
    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/list-of-user")
    public String getListUsers() {
        return libraryService.findAllUsers().toString();
    }

    @GetMapping("/list-of-books")
    public String getListBooks() {
        return libraryService.findAllBooks().toString();
    }


}
