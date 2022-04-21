package lib.service;

import lib.model.Book;
import lib.model.LogEntry;
import lib.model.User;
import lib.repository.BookRepository;
import lib.repository.ListBorrowedRepository;
import lib.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final ListBorrowedRepository listBRepository;

    @Autowired
    public LibraryService(UserRepository userRepository, BookRepository bookRepository, ListBorrowedRepository listBRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.listBRepository = listBRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public List<LogEntry> getAllLogEntry() {
        return listBRepository.findAll();
    }

    public List<LogEntry> getListReturnedBooks(boolean b) {
        System.out.println(b);
        return listBRepository.findByReturned(b);
    }

    public User getUserById(Long id) {
        return userRepository.getById(id);
    }

    public Book getBookById(Long id) {
        return bookRepository.getById(id);
    }
    public Integer getNumberOfBooks(Long id){
        return bookRepository.findNumberBooksById(id);
    }

    public List<LogEntry> getEntryByStudentId(Long id) {
        return listBRepository.findBEntryByStudentId(id);
    }

    public List<LogEntry> getEntryByStudentIdAndReturned(Long id, boolean b) {
        return listBRepository.findBEntryByStudentIdAndReturned(id, b);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
    public LogEntry saveLogEntry(LogEntry logEntry){
        logEntry.setReturned(false);
        return listBRepository.save(logEntry);
    }

}
