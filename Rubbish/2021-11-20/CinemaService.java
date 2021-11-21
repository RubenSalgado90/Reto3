package co.usa.ciclo3.Ciclo3.service;


import co.usa.ciclo3.Ciclo3.model.Cinema;
import co.usa.ciclo3.Ciclo3.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getAll() {
        return cinemaRepository.getAll();
    }

    public Optional<Cinema> getCinema(int id) {
        return cinemaRepository.getCinema(id);
    }

    public Cinema save(Cinema c) {
        if (c.getId() == null) {
            return cinemaRepository.save(c);
        } else {
            Optional<Cinema> ciaux = cinemaRepository.getCinema(c.getId());
            if (ciaux.isEmpty()) {
                return cinemaRepository.save(c);
            } else {
                return c;
            }
        }
    }
    public CinemaRepository getCinemaRepository() {
        return cinemaRepository;
    }
}


