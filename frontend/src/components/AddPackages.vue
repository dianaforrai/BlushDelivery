<template>
    URSULET PENTRU BARGA IUBITUL MEU
    <div class="container">
        <div class="mb-3">
          <label for="deliveryAddress" class="form-label">Delivery address</label>
          <input v-model="deliveryAddress" type="text" class="form-control" id="deliveryAddress"
            required>
        </div>
        <div class="mb-3">
            <label for="type" class="form-label">Payment method</label>
            <input type="checkbox" class="btn-check" id="btn-check-2" checked autocomplete="off" :disabled="payOnDelivery" @click="togglePayOnDelivery">
            <label class="btn btn-primary custom-checkbox" for="btn-check-2">PayOnDelivery</label>
            <input type="checkbox" class="btn-check" id="btn-check-3" autocomplete="off" :disabled="!payOnDelivery" @click="togglePayOnDelivery">
<label class="btn btn-primary custom-checkbox" for="btn-check-3">PayOnline</label>
        </div>
        <div class="mb-3">
            <label for="type" class="form-label">Status</label>
        <select class="type-select form-control"
                                aria-label="Type" aria-describedby="inputGroup-sizing-default">
                                <option value="NEW">New</option>
                                <option value="PENDING">Pending</option>
                                <option value="DELIVERED">Delivered</option>    
                            </select>
        </div>
    </div>
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
  background-color: rgb(99, 44, 52) ;
  color: white; /* White text */
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