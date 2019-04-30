package booktrade.api.controller;


import booktrade.api.entites.Request;
import booktrade.api.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RequestController {

    @Autowired
    private RequestService service;


    @PostMapping(value = "/api/users/{email}/requests")
    public void addRequest(@RequestBody Request request){
        service.addRequest(request);
    }

    @GetMapping(value = "/api/users/{email}/requests")
    public Iterable<Request> getUserRequests(@PathVariable String email){
        return service.getUserRequests(email);
    }

    @PutMapping(value = "/api/users/{email}/requests/{requestId}")
    public void updateRequest(@RequestBody Request request,@PathVariable Long requestId){
        service.updateRequest(request,requestId);
    }

    @GetMapping(value = "/api/users/{email}/requests/{requestId}")
    public Optional<Request> getUserRequest(@PathVariable Long requestId){
        return service.getUserRequest(requestId);
    }

    //TODO: remove after demo
    @GetMapping(value = "/api/users/{email}/requests/completed")
    public List<Request> getUserCompletedRequests(@PathVariable String email){
        return service.getUserCompletedRequests(email);
    }
}
