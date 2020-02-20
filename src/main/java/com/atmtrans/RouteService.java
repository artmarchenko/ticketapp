package com.atmtrans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RouteService {

    @Autowired
    private RouteRepository repo;

    public List<Route> listAll() {
        return repo.findAll();
    }

    public void save(Route route) {
        repo.save(route);
    }

    public Route get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
