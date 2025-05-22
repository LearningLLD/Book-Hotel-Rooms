package com.example.bookrooms.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.bookrooms.models.CustomerSession;
import com.example.bookrooms.models.CustomerSessionStatus;

public class CustomerSessionRepositoryImpl implements CustomerSessionRepository {

    List<CustomerSession> customerSessionsDb = new ArrayList<>();
    @Override
    public CustomerSession save(CustomerSession customerSession) {
        customerSessionsDb.add(customerSession);
        return customerSession;
    }

    @Override
    public Optional<CustomerSession> findActiveCustomerSessionByUserId(long userId) {
        return customerSessionsDb.stream().
        filter(session -> session.getCustomerSessionStatus() == CustomerSessionStatus.ACTIVE).
        filter(session -> session.getUser().getId() == userId).
        findFirst(); 
    }
    
}
