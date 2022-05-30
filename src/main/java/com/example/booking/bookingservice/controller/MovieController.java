package com.example.booking.bookingservice.controller;

import com.example.booking.bookingservice.entity.BookingEntity;
import com.example.booking.bookingservice.entity.MovieShowTime;
import com.example.booking.bookingservice.handler.CustomException;
import com.example.booking.bookingservice.model.ValidResponse;
import com.example.booking.bookingservice.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(name = "/v2", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {

    @Autowired
    MovieService movieService;


    @GetMapping("/movies/city")
    public ResponseEntity<ValidResponse<Map<String, List<MovieShowTime>>>> getAllMovie(
            @PathVariable(name="city", required = true)
            String city

    )throws Exception{
        ValidResponse response = new ValidResponse();
        HttpStatus status = HttpStatus.OK;
        //theatreId, List of Shows by City
        Map<String, List<MovieShowTime>> movieMap = null;
        String message = null;

        try {
            movieMap = movieService.getMoviesShowTimeByCity(city);
            response.setData(movieMap);

            //nned to add condition for HTTP.NO_CONTENT
        }catch (Exception e){
            status = HttpStatus.BAD_GATEWAY;
            message = "ERROR - got error while fetching movies"+ e.getMessage();
            log.error(message,e);
            throw new CustomException(response, message);
        }

        return new ResponseEntity<>(response, status);
    }


    @PostMapping("/book-movie")
    @Transactional
    public ResponseEntity<ValidResponse<BookingEntity>> bookMovie(
            @RequestParam(name="movieID", required = true) String movieID,
            @RequestParam(name="theatreID", required = true) String theatreID,
            @RequestParam(name="userID", required = true) String userID,
            @RequestParam(name="showTime", required = true) String showTime,
            @RequestParam(name="date", required = true) String date,
            @RequestParam(name="seatNumber", required = true) String seatNumber
    )throws Exception{
        ValidResponse response = new ValidResponse();
        HttpStatus status = HttpStatus.OK;
        BookingEntity bookResponse = null;
        String message = null;

        try {
            bookResponse = movieService.bookTicket(movieID, theatreID, userID, showTime, date, seatNumber);

            if (bookResponse==null){
                response.setData(null);
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }else{
                response.setData(bookResponse);
            }


            //nned to add condition for HTTP.NO_CONTENT
        }catch (Exception e){
            status = HttpStatus.BAD_GATEWAY;
            message = "ERROR - got error while fetching movies"+ e.getMessage();
            log.error(message,e);
            throw new CustomException(response, message);
        }
        return new ResponseEntity<>(response, status);
    }


}
