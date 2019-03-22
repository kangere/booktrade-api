package booktrade.api.service;

import booktrade.api.entites.Author;
import booktrade.api.entites.Book;
import booktrade.api.entites.OwnedBook;
import booktrade.api.entites.OwnedBooksPK;
import booktrade.api.repository.AuthorRepository;
import booktrade.api.repository.BookRepository;
import booktrade.api.repository.OwnedBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private OwnedBooksRepository ownedBooksRepository;

    @Autowired
    private AuthorRepository authorRepository;

    //cache of existing book details
    //To reduce number of calls to book table
    //TODO: Find a more standard way of doing this
    private static List<Book> books = new ArrayList<>();

    public void addBook(OwnedBook owned){

        Book b = owned.getBook();
        //Check if book details already exist
        if(!bookExists(b)) {
            //Save Authors
            List<Author> authors = b.getAuthors();
            authors.forEach(auth -> authorRepository.save(auth));

            //save books
            bookRepository.save(b);
        }

        ownedBooksRepository.save(owned);
    }

    /**
     * Finds all the books that have been added to the books table
     * @return a list of all books in the table
     */
    private List<Book> getBooks(){

        Iterable<Book> booksIter = bookRepository.findAll();

        List<Book> bs = new ArrayList<>();

        booksIter.forEach(bs::add);

        return bs;
    }

    /**
     * Checks if a book exists in the books table
     * @param b - the book to be checked
     * @return true if the book is n the table false otherwise
     */
    private boolean bookExists(Book b){
        if(books.isEmpty())
            books = getBooks();

        return books.contains(b);
    }

    public Iterable<Book> getUsersBooks(String email){

        List<OwnedBook> ownersBooks = ownedBooksRepository.findByEmail(email);

        List<Book> usersBooks = new ArrayList<>();

        ownersBooks.forEach(o -> usersBooks.add(o.getBook()));

        return usersBooks;
    }

    public Iterable<Book> getAvailableBooks(){

        return bookRepository.findAllAvailableBooks();

    }

    public void deleteUserBook(String email,Long isbn){
        OwnedBooksPK pk = new OwnedBooksPK(email,isbn);
        ownedBooksRepository.deleteById(pk);
    }

    public boolean updateBookDetails(Book book){
        if(!bookExists(book))
            return false;

        Book old = bookRepository.findById(book.getIsbn()).get();


        bookRepository.save(book);
        return true;
    }

    public Iterable<Book> findBooksByTitle(String title){
        return bookRepository.findByTitle(title);
    }
}
