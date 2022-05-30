package com.example.booking.bookingservice.service.impl;

import com.example.booking.bookingservice.entity.MovieShowTime;
import com.example.booking.bookingservice.entity.Theatre;
import com.example.booking.bookingservice.repository.MovieShowTimeRepository;
import com.example.booking.bookingservice.repository.TheatreRepository;
import com.example.booking.bookingservice.service.TheatreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    TheatreRepository theatreRepo;

    @Autowired
    MovieShowTimeRepository movieShowTimeRepository;

    @Override
    public boolean addTheatre(Theatre theatre) throws Exception {
        Theatre t = theatreRepo.save(theatre);
        if(t!=null){
            return true;
        }

        return false;
    }

    @Override
    public boolean addShowTime(String movieName, String theatreId, String showTime) throws Exception {

        //hardcode price temp
        MovieShowTime show = new MovieShowTime(movieName,theatreId,showTime,"300");
        MovieShowTime result = movieShowTimeRepository.save(show);

        if(result!=null){
            return true;
        }
        return false;
    }


}
