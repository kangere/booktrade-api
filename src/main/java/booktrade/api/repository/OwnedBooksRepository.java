package booktrade.api.repository;

import booktrade.api.entites.OwnedBook;
import booktrade.api.entites.OwnedBooksPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnedBooksRepository extends CrudRepository<OwnedBook, OwnedBooksPK> {

    /**
     * Finds a list of all the books a particular user owns
     * @param email - email of the user
     * @return - Iterable list of the book isbns that the user owns
     */
    List<OwnedBook> findByEmail(String email);


    @Query(value = "select o from owned_books o where o.isbn=?1 and o.email <> ?2 and o.available ='True'")
    List<OwnedBook> findByIsbn(Long isbn, String email);
}
