package com.example.booking.bookingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(MovieShowTimeKey.class)
public class MovieShowTime {

    @Id
    @Column
    String movieName;

    @Id
    @Column
    String theatreId;

    @Column
    String showTime;

    String price;

}
