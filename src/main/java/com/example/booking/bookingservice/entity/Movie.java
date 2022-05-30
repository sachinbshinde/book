package com.example.booking.bookingservice.entity;

import com.example.booking.bookingservice.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table
public class Movie {

    @Id
    String movieName;

    String theatreID;
    String userID;


}
