package booktrade.api.controller;

import booktrade.api.entites.Book;
import booktrade.api.entites.OwnedBook;
import booktrade.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping(value = "/api/users/{email}/books")
    public void addBook(@RequestBody OwnedBook ownedBook, @PathVariable String email){
        ownedBook.setEmail(email);
        service.addBook(ownedBook);
    }

    @GetMapping(value = "/api/users/{email}/books")
    public Iterable<Book> getUsersBooks(@PathVariable String email){
        return service.getUsersBooks(email);
    }


    @GetMapping(value = "/api/books")
    public Iterable<Book> getAvailableBooks(){
        return service.getAvailableBooks();
    }

    @DeleteMapping(value = "/api/users/{email}/books/{isbn}")
    public void deleteUserBook(@PathVariable String email, @PathVariable Long isbn){
        service.deleteUserBook(email,isbn);
    }

    @PutMapping(value = "/api/users/{email}/books/{isbn}")
    public ResponseEntity<Object> updateBookDetails(@RequestBody Book book){
        if(service.updateBookDetails(book))
            return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }
}
