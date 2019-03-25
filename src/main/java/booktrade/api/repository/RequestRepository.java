package booktrade.api.repository;

import booktrade.api.entites.Request;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request,Long> {

    @Query(value = "select r from requests r where r.ownerEmail = ?1 or r.requesterEmail=?1")
    Iterable<Request> findAllUserRequests(String email);
}
