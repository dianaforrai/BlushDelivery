<template>
   <div>
     <table class="table table-striped">
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
 
 export default {
   name: 'ViewPackages',
   data() {
     return {
       packages: Packages
     };
   }
 };
 </script>
 
 <style scoped>
 /* Add any necessary styles here */
 </style>