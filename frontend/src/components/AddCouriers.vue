<template>
  URSULET PENTRU BARGA IUBITUL MEU
  <div class="container">
    <div class="mb-3">
      <label for="deliveryAddress" class="form-label">Delivery address</label>
      <input v-model="deliveryAddress" type="text" class="form-control" id="deliveryAddress" required>
    </div>
    <div class="mb-3">
      <label for="type" class="form-label">Payment method</label>
      <input type="checkbox" class="btn-check" id="btn-check-2" checked autocomplete="off" :disabled="payOnDelivery"
        @click="togglePayOnDelivery">
      <label class="btn btn-primary custom-checkbox" for="btn-check-2">PayOnDelivery</label>
      <input type="checkbox" class="btn-check" id="btn-check-3" autocomplete="off" :disabled="!payOnDelivery"
        @click="togglePayOnDelivery">
      <label class="btn btn-primary custom-checkbox" for="btn-check-3">PayOnline</label>
    </div>
    <div class="mb-3">
      <label for="type" class="form-label">Status</label>
      <select class="type-select form-control" aria-label="Type" aria-describedby="inputGroup-sizing-default">
        <option value="NEW">New</option>
        <option value="PENDING">Pending</option>
        <option value="DELIVERED">Delivered</option>
      </select>
    </div>
  </div>
  <button @click="addPackage" class="btn-addpackage"> <i class="fa-solid fa-right-from-bracket"></i> Add
    Package</button>
</template>

<script>
export default {
  name: 'AddPackages',
  props: {
    msg: String
  },
  data() {
    return {
      deliveryAddress: '',
      payOnDelivery: true
    };
  },
  methods: {
    addPackage(event) {
      event.preventDefault();
    },
    togglePayOnDelivery() {
      this.payOnDelivery = !this.payOnDelivery;
    }
  }
}
</script>
<style scoped>
.custom-checkbox {
  background-color: rgb(99, 44, 52);
  color: white;
  /* White text */
  border: none;
  padding: 10px 20px;
  cursor: pointer;
}

.custom-checkbox:hover {
  background-color: rgb(99, 44, 52);
}

.custom-checkbox:active {
  background-color: rgb(99, 44, 52);
}
</style>
<style scoped>
.btn-addpackage:hover {
  transform: translateY(-5px);
}

.main-navigation li {
  color: rgb(172, 72, 89);
  /* Change this to your desired color */
}

.btn-addpackage {
  position: middle;
  top: 1rem;
  right: 1rem;
  background-color: rgb(172, 72, 89);
  color: white;
  border-color: lightpink;
  border-radius: 1rem;
  padding: 0.5rem 1rem;
  font-size: 1rem;
  cursor: pointer;
  font-weight: bold;
  box-shadow: 2px 2px 2px 1px var(--box-shadow-color);
  animation: slide-up-fade-in 1s ease;
  transition: transform 0.5s ease;
}

.lista {
  list-style-type: none;
  text-decoration: none;
}
</style>