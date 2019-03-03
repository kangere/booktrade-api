package booktrade.api.repository;

import booktrade.api.entites.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Integer> {
}
