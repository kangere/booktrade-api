package booktrade.api.repository;

import booktrade.api.entites.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {
}
