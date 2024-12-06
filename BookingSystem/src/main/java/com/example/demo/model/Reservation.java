package com.example.demo.model;

import lombok.Data;

@Data
public class Reservation {
	 private Integer id;
	    private String customerName;
	    private String phoneNumber;
	    private String reservationDate;
	    private String reservationTime;
	    private Integer seats;
		public Reservation(String customerName, String phoneNumber, String reservationDate, String reservationTime,
				Integer seats) {
			super();
			this.customerName = customerName;
			this.phoneNumber = phoneNumber;
			this.reservationDate = reservationDate;
			this.reservationTime = reservationTime;
			this.seats = seats;
		}
		public Reservation() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
	    
	    

}
