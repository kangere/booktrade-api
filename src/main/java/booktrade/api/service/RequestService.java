package booktrade.api.service;

import booktrade.api.entites.OwnedBook;
import booktrade.api.entites.OwnedBooksPK;
import booktrade.api.entites.Request;
import booktrade.api.repository.OwnedBooksRepository;
import booktrade.api.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    private RequestRepository repository;

    @Autowired
    private OwnedBooksRepository ownedBooksRepository;

    public void addRequest(Request request){
        repository.save(request);

        OwnedBooksPK pk1 = new OwnedBooksPK(request.getOwnerEmail(),request.getOwnerBook());
        OwnedBooksPK pk2 = new OwnedBooksPK(request.getRequesterEmail(),request.getRequesterBook());

        Optional<OwnedBook> owner = ownedBooksRepository.findById(pk1);
        Optional<OwnedBook> requester = ownedBooksRepository.findById(pk2);

        //Make books in request status unavailable
        owner.ifPresent(ownedBook -> {
            ownedBook.setAvailable(OwnedBook.Availability.False);
            ownedBooksRepository.save(ownedBook);
        });

        requester.ifPresent( ownedBook -> {
            ownedBook.setAvailable(OwnedBook.Availability.False);
            ownedBooksRepository.save(ownedBook);
        });
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


            OwnedBooksPK pk1 = new OwnedBooksPK(request.getOwnerEmail(),request.getOwnerBook());
            OwnedBooksPK pk2 = new OwnedBooksPK(request.getRequesterEmail(),request.getRequesterBook());

            Optional<OwnedBook> owner = ownedBooksRepository.findById(pk1);
            Optional<OwnedBook> requester = ownedBooksRepository.findById(pk2);

            if(Request.RequestStatus.DECLINED.equals(request.getStatus()) ||
                    Request.RequestStatus.RETRACTED.equals(request.getStatus())){
                //TODO : Inform user
                owner.ifPresent(ownedBook -> {
                    ownedBook.setAvailable(OwnedBook.Availability.True);
                    ownedBooksRepository.save(ownedBook);
                });

                requester.ifPresent( ownedBook -> {
                    ownedBook.setAvailable(OwnedBook.Availability.True);
                    ownedBooksRepository.save(ownedBook);
                });

            } else if(Request.RequestStatus.COMPLETED.equals(request.getStatus())){
                //TODO:  insert to orders table, inform users of trade
                //TODO: inform users to drop off books to drop off point for delivery
            }
        }
    }

    public List<Request> getUserCompletedRequests(String email){
        return repository.findAllCompletedRequests(email);
    }
}
