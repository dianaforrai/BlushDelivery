<template>
  <div class="container-flowup">
    <table class="table table-striped pink-table">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Delivery Address</th>
          <th scope="col">Payment Method</th>
          <th scope="col">Courier</th>
          <th scope="col">Status</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="pack in packages" :key="pack.id">
          <th scope="row">{{ pack.id }}</th>
          <td>{{ pack.deliveryAddress }}</td>
          <td>{{ pack.payOnDelivery ? 'Pay on Delivery' : 'Prepaid' }}</td>
          <td>{{ pack.courier.name }}</td>
          <td>{{ pack.status }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import Packages from '../assets/packages.json';
import axios from 'axios';
export default {
  name: 'ViewPackages',
  data() {
    return {
      packages: []
    };
  },
  created() {
    this.fetchPackages();
  },
  methods: {
    fetchPackages() {
      axios.get(`http://localhost:8083/packages`)
        .then(response => {
          console.log(response);
          this.packages = response.data;
        })
        .catch(error => {
          console.error(error);
        });
    }
  }
};
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