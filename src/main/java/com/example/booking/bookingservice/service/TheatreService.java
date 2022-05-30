package com.example.booking.bookingservice.service;

import com.example.booking.bookingservice.entity.Theatre;

public interface TheatreService {
    boolean addTheatre(Theatre theatre) throws Exception;

    boolean addShowTime(String movieName, String theatreId, String showTime) throws Exception;
}
