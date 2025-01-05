<template>
  BARGA ESTE URSULETUL MEU SI PE EL IL IUUUUBESC TARE TARE TARE
  <div class="mb-3">
    <label for="type" class="form-label">Couriers</label>
    <select class="type-select form-control" aria-label="Type" aria-describedby="inputGroup-sizing-default">
      <option v-for="courier in couriers" :key="courier.id" :value="courier.id"> {{ courier.email }} </option>


    </select>
  </div>
  <div class="mb-3">
    <label for="type" class="form-label">Packages</label>
    <select class="type-select form-control" aria-label="Type" aria-describedby="inputGroup-sizing-default">
      <option v-for="pack in packages" :key="pack.id" :value="pack.id"> {{ pack.deliveryAdress }} </option>
    </select>
  </div>
  <button @click="set" class="btn-set"> <i class="fa-solid fa-right-from-bracket"></i>Assign</button>
</template>

<script>
export default {
  name: 'SetManager',
}
</script>
<style scoped>
.btn-set:hover {
  transform: translateY(-5px);
}

.main-navigation li {
  color: rgb(172, 72, 89);
  /* Change this to your desired color */
}

.btn-set {
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