package com.example.booking.bookingservice.service.impl;

import com.example.booking.bookingservice.entity.BookingEntity;
import com.example.booking.bookingservice.entity.MovieShowTime;
import com.example.booking.bookingservice.entity.Theatre;
import com.example.booking.bookingservice.repository.BookingRepository;
import com.example.booking.bookingservice.repository.MovieShowTimeRepository;
import com.example.booking.bookingservice.repository.TheatreRepository;
import com.example.booking.bookingservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

public class MovieServiceImpl implements MovieService {

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    MovieShowTimeRepository movieShowTimeRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public Map<String, List<MovieShowTime>> getMoviesShowTimeByCity(String city) throws Exception{

        Set<Theatre> theatreList = theatreRepository.getTheatreByCity(city);
        //extract theatre Id from list
        List<String> theatreIdList = theatreList.stream().map(t -> t.getTheatreID()).collect(Collectors.toList());

        Map<String, List<MovieShowTime>> showMap = new HashMap<>();

        for(String id : theatreIdList){
            List<MovieShowTime> list = movieShowTimeRepository.getMovieShowTimeByTheatreId(id);
            showMap.put(id,list);
        }

        return showMap;
    }

    @Override
    @Transactional
    public BookingEntity bookTicket(String movieID, String theatreID, String userID, String showTime, String date, String seatNumber) throws Exception {

        boolean available = isSeatAvailable(movieID, theatreID, showTime, date, seatNumber);
        BookingEntity book = new BookingEntity();
        book.setMovieName(movieID);
        book.setDate(date);
        book.setSeatNumber(seatNumber);
        book.setShowTime(showTime);
        book.setTheatreName(theatreID);
        book.setUserId(userID);

        if(available){
            book = bookingRepository.save(book);
            markSeatBooked(seatNumber, date, showTime, movieID, theatreID);
        }else{
            return null;
        }


        return book;
    }


    //need to define this method with logic to verify if seat is available
    public boolean isSeatAvailable(String movieID, String theatreID, String showTime, String date, String seatNumber){
        return true;
    }

    //need to update this in DB. With seat booked
    @Transactional
    public boolean markSeatBooked(String seatNumber, String date, String showTime, String movieID, String theatreID){
        return true;
    }
}
