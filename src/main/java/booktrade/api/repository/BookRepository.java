package booktrade.api.repository;

import booktrade.api.entites.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,Long> {

    /**
     * Finds all the books the book details for those books that are available in stock
     * @return List of books available
     */
    @Query(value = "select b from books b where b.isbn IN (select distinct o.isbn from owned_books o)")
    List<Book> findAllAvailableBooks();
}
