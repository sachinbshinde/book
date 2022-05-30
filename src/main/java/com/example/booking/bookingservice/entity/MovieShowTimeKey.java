package com.example.booking.bookingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor @AllArgsConstructor
public class MovieShowTimeKey implements Serializable {

    String movieName;
    String theatreId;
}
