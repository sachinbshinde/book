package com.example.booking.bookingservice.repository;

import com.example.booking.bookingservice.entity.MovieShowTime;
import com.example.booking.bookingservice.entity.MovieShowTimeKey;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieShowTimeRepository extends CrudRepository<MovieShowTime, MovieShowTimeKey> {

    public List<MovieShowTime> getMovieShowTimeByTheatreId(String theatreId);
}
