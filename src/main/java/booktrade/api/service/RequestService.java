package booktrade.api.service;

import booktrade.api.entites.Request;
import booktrade.api.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    private RequestRepository repository;

    public void addRequest(Request request){
        repository.save(request);
    }

    public Iterable<Request> getUserRequests(String email){
        return repository.findAllUserRequests(email);
    }

    public Optional<Request> getUserRequest(Long requestId){
        return repository.findById(requestId);
    }

    public void updateRequest(Request request,Long requestId) {
        Optional<Request> old = repository.findById(requestId);

        if (old.isPresent()) {

            request.setCompletedAt(new Date());
            repository.save(request);

            if(Request.RequestStatus.DECLINED.equals(request.getStatus())){
                //TODO : Inform user
            } else if(Request.RequestStatus.RETRACTED.equals(request.getStatus())){
                //TODO: Inform User
            } else if(Request.RequestStatus.COMPLETED.equals(request.getStatus())){
                //TODO:  insert to orders table, inform users of trade
                //TODO: inform users to drop off books to drop off point for delivery
            }
        }
    }
}
