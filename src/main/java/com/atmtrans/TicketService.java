package com.atmtrans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TicketService  {
    @Autowired
    private TicketRepository repo;

    public List<Ticket> listAll() {
        return repo.findAll();
    }

    public void save(Ticket ticket) {
        repo.save(ticket);
    }

    public Ticket get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
