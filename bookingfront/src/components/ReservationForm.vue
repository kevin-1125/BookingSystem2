<template>
    <form @submit.prevent="submitForm">
      <div>
        <label>Customer Name:</label>
        <input v-model="reservation.customerName" required />
      </div>
      <div>
        <label>Phone Number:</label>
        <input v-model="reservation.phoneNumber" required />
      </div>
      <div>
        <label>Date:</label>
        <input type="date" v-model="reservation.reservationDate" required />
      </div>
      <div>
        <label>Time:</label>
        <input type="time" v-model="reservation.reservationTime" required />
      </div>
      <div>
        <label>Seats:</label>
        <input type="number" v-model="reservation.seats" required />
      </div>
      <button type="submit">Submit</button>
    </form>
  </template>
  
  <script>
  import apiClient from "../api";
  
  export default {
    data() {
      return {
        reservation: {
          customerName: "",
          phoneNumber: "",
          reservationDate: "",
          reservationTime: "",
          seats: 1,
        },
      };
    },
    methods: {
      async submitForm() {
        await apiClient.post("/reservations", this.reservation);
        alert("Reservation Created!");
        this.$emit("refresh");
      },
    },
  };
  </script>
  