package com.example.booking.bookingservice.repository;

import com.example.booking.bookingservice.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<BookingEntity, String> {
}
