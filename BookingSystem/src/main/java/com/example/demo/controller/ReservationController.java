package com.example.demo.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.ReservationMapper;
import com.example.demo.model.Reservation;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin
public class ReservationController {
	@Autowired
   ReservationMapper reservationMapper;

    public ReservationController(ReservationMapper reservationMapper) {
        this.reservationMapper = reservationMapper;
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationMapper.findAll();
    }

    @PostMapping
    public void createReservation(@RequestBody Reservation reservation) {
        reservationMapper.save(reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Integer id) {
        reservationMapper.deleteById(id);
    }
}
