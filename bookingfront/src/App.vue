<template>
  <div id="app">
    <h1>Reservation System</h1>
    <reservation-form @refresh="fetchReservations" />
    <div v-for="reservation in reservations" :key="reservation.id">
      <p>
        {{ reservation.customerName }} - {{ reservation.reservationDate }} @
        {{ reservation.reservationTime }} ({{ reservation.seats }} seats)
        <button @click="deleteReservation(reservation.id)">Delete</button>
      </p>
    </div>
  </div>
</template>

<script>
import apiClient from "./api";
import ReservationForm from "./components/ReservationForm.vue";

export default {
  components: { ReservationForm },
  data() {
    return {
      reservations: [],
    };
  },
  methods: {
    async fetchReservations() {
      const response = await apiClient.get("/reservations");
      this.reservations = response.data;
    },
    async deleteReservation(id) {
      await apiClient.delete(`/reservations/${id}`);
      this.fetchReservations();
    },
  },
  mounted() {
    this.fetchReservations();
  },
};
</script>
