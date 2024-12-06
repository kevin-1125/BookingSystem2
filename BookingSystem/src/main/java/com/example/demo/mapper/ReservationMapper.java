package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.Reservation;

@Mapper
public interface ReservationMapper {
	@Select("SELECT * FROM reservations")
    List<Reservation> findAll();

    @Insert("INSERT INTO reservations (customer_name, phone_number, reservation_date, reservation_time, seats) " +
            "VALUES (#{customerName}, #{phoneNumber}, #{reservationDate}, #{reservationTime}, #{seats})")
    void save(Reservation reservation);

    @Delete("DELETE FROM reservations WHERE id = #{id}")
    void deleteById(Integer id);

}
