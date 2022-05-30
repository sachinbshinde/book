package com.example.booking.bookingservice.entity;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity @Table
@Data @NoArgsConstructor @AllArgsConstructor
public class BookingEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookingId;

    private String movieName;//movie id and name
    private String theatreName;
    private String date;
    private String showTime;
    private String seatNumber;
    private String userId;

}
