package booktrade.api.repository;

import booktrade.api.entites.Request;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RequestRepository extends CrudRepository<Request,Long> {

    @Query(value = "select r from requests r where (r.ownerEmail = ?1 or r.requesterEmail=?1) and (r.status = 'ACTIVE')")
    Iterable<Request> findAllUserRequests(String email);

    @Query(value = "select r from requests r where (r.ownerEmail = ?1 or r.requesterEmail=?1) and (r.status = 'COMPLETED')")
    List<Request> findAllCompletedRequests(String email);
}
