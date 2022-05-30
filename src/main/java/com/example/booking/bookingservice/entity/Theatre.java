package com.example.booking.bookingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Theatre {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    String theatreID;

    @Column
    String theatreName;

    @Column
    String city;

}
