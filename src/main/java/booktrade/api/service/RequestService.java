package booktrade.api.service;

import booktrade.api.entites.Request;
import booktrade.api.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    private RequestRepository repository;

    public void addRequest(Request request){
        repository.save(request);
    }

    public Iterable<Request> getUserRequests(String email){
        return repository.findAllUserBooks(email);
    }

    public Optional<Request> getUserRequest(Long requestId){
        return repository.findById(requestId);
    }
}
