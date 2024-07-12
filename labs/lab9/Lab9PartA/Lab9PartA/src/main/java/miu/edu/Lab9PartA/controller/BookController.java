package miu.edu.Lab9PartA.controller;

import miu.edu.Lab9PartA.domain.Book;
import miu.edu.Lab9PartA.domain.Books;
import miu.edu.Lab9PartA.exceptions.BookException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookController {

   private HashMap<String, Book> books = new HashMap<>();

   @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book) {

        try {
            if(books.containsKey(book.getIsbn())) {
                throw new BookException("isbn already exists");
            }
            books.put(book.getIsbn(), book);

            return new ResponseEntity<Book>(book,HttpStatus.OK);
        }
        catch (BookException e) {
            System.out.println(e);
            return new ResponseEntity<>(e.getMessage() ,HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping
    public ResponseEntity<?> updateBook(@RequestBody Book book) {
        if(books.containsKey(book.getIsbn())) {
            books.put(book.getIsbn(), book);
            return new ResponseEntity<Book>(book,HttpStatus.OK);
        }
        return new ResponseEntity<String>("Book not found",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{ISBN}")
    public ResponseEntity<?> deleteBook(@PathVariable String ISBN) {
        if(books.containsKey(ISBN)) {
            books.remove(ISBN);
            return new ResponseEntity<String>("Book deleted",HttpStatus.OK);
        }
        return new ResponseEntity<String>("Book not found",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{ISBN}")
    public ResponseEntity<?> getBook(@PathVariable String ISBN) {
        if(books.containsKey(ISBN)) {
            return new ResponseEntity<Book>(books.get(ISBN),HttpStatus.OK);
        }
        return new ResponseEntity<String>("Book not found",HttpStatus.NOT_FOUND);
    }
    @GetMapping
    public ResponseEntity<?> getBooks(@RequestParam Optional<String> author) {
        if (author.isPresent()) {
            Books book = new Books();
            for (Book b : books.values()) {
                if (b.getAuthor().equals(author.get())) {
                    book.getBooks().add(b);
                }
            }
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            Books book = new Books(books.values());
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
    }
}
