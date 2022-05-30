package com.example.booking.bookingservice.service;

import com.example.booking.bookingservice.entity.BookingEntity;
import com.example.booking.bookingservice.entity.MovieShowTime;

import java.util.List;
import java.util.Map;

public interface MovieService {

    public Map<String, List<MovieShowTime>> getMoviesShowTimeByCity(String city) throws Exception;

    BookingEntity bookTicket(String movieID, String theatreID, String userID, String showTime, String date, String seatNumber) throws Exception;
}
