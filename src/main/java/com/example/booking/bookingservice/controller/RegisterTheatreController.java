package com.example.booking.bookingservice.controller;

import com.example.booking.bookingservice.entity.Theatre;
import com.example.booking.bookingservice.model.ValidResponse;
import com.example.booking.bookingservice.service.TheatreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(name = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegisterTheatreController {

    @Autowired
    private TheatreService theatreService;

    //register theatre
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/register-theatre")
    public ResponseEntity<ValidResponse<String>> registerTheatre(
            @RequestBody Theatre theatre
    ) {

        ValidResponse rersponse = new ValidResponse();
        HttpStatus status = HttpStatus.OK;
        String message = null;

        try {
            if(theatre != null){
                boolean result = theatreService.addTheatre(theatre);
                if(result){
                    status = HttpStatus.OK;
                    message = "SUCCESS - Theatre registered successfully.";
                    log.info(message);
                }else{
                    status = HttpStatus.INTERNAL_SERVER_ERROR;
                    message = "FAILED - Failed to register Theatre.";
                    log.error(message);
                }
            }else{
                status = HttpStatus.BAD_REQUEST;
                message = "ERROR - No request body found";
                log.error(message);
            }
        }catch (Exception e){
            status = HttpStatus.BAD_GATEWAY;
            message = "ERROR - got error while updating record"+ e.getMessage();
            log.error(message,e);
        }

        rersponse.setResponseMessage(message);
        return new ResponseEntity<>(rersponse, status);
    }


    //add movies to theatres with time and price
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/register-movie")
    public ResponseEntity<ValidResponse<String>> addMovie(
            @RequestParam(name="movieID", required = true)
            String movieName,
            @RequestParam(name="theatreID", required = true)
            String theatreId,
            @RequestParam(name = "showTime", required = true)
            String showTime,
            @RequestParam(name = "price", required = true)
            String price
    ){

        ValidResponse<String> rersponse = new ValidResponse<>();
        HttpStatus status = HttpStatus.OK;
        String message = null;

        //e.g movieId = 1, theatreId = 123, showTime = 7.00 PM
        //theatre admin need to register multiple time to add shows of movies
        //Considering movie ID as Movie name
        try {
            boolean result = theatreService.addShowTime(movieName, theatreId, showTime);

            if(result){
                status = HttpStatus.OK;
                message = "SUCCESS - Theatre registered successfully.";
                log.info(message);
            }else{
                status = HttpStatus.INTERNAL_SERVER_ERROR;
                message = "FAILED - Failed to register Theatre.";
                log.error(message);
            }

        }catch(Exception ex){
            status = HttpStatus.BAD_GATEWAY;
            message = "ERROR - got error while updating record"+ ex.getMessage();
            log.error(message,ex);
        }

        rersponse.setResponseMessage(message);
        return new ResponseEntity<>(rersponse, status);
    }

    //Need to define below functional requirement as well
    /*
    1. method to deRegisterTheatre
    2. method to update movie shows/showtime
    3.

     */

}
