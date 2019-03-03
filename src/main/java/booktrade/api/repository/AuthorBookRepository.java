package booktrade.api.repository;

import booktrade.api.entites.AuthorBook;
import booktrade.api.entites.AuthorBookPK;
import org.springframework.data.repository.CrudRepository;

public interface AuthorBookRepository extends CrudRepository<AuthorBook, AuthorBookPK> {
}
