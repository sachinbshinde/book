package com.example.booking.bookingservice.handler;

import com.example.booking.bookingservice.model.ValidResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CustomException extends Exception{

    ValidResponse response;
    String message;

    public CustomException(ValidResponse response, String message){
        super(message);
    }


}
