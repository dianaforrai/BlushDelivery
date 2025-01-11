<template>
  <div class="container-flowup">
    <table class="table table-striped pink-table">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Name</th>
          <th scope="col">Email</th>
          <th scope="col">Manager</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="courier in couriers" :key="courier.id">
          <th scope="row">{{ courier.id }}</th>
          <td>{{ courier.name }}</td>
          <td>{{ courier.email }}</td>
          <td>{{ courier.manager ? courier.manager.name : 'None' }}</td>
        </tr>
      </tbody>
    </table>
  </div>
  <button class="home-btn" :onclick="home">Home</button>
</template>

<script>
import axios from 'axios';

export default {
  name: 'AvailableCouriers',
  props: {
    msg: String
  },
  data() {
    return {
      couriers: []
    };
  },
  created() {
    this.fetchCouriers();
  },
  methods: {
    home() {
      this.$router.push('/');
    },
    fetchCouriers() {
      axios.get(`http://localhost:8083/couriers/no-pending-packages`)
        .then(response => {
          console.log(response);
          this.couriers = response.data;
        })
        .catch(error => {
          console.error(error);
        });
    }
  }
}
</script>

<style scoped>
.pink-table {
  border: 1px solid pink;
}

.pink-table th {
  background-color: rgb(99, 44, 52);
  color: white;
}

.pink-table td {
  background-color: #ffe6f2;
  color: black;
}

.pink-table tr:nth-child(even) {
  background-color: #ffccdd;
}

.pink-table tr:hover {
  background-color: #ff99bb;
}
</style>