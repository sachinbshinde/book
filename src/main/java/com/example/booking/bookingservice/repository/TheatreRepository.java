package com.example.booking.bookingservice.repository;


import com.example.booking.bookingservice.entity.Theatre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface TheatreRepository extends CrudRepository<Theatre, String> {

    public Set<Theatre> getTheatreByCity(String city);
}
