<template>
    <div class="container-flowup">
        <h1>Package Details</h1>
        <div v-if="packageData !== null && packageData !== undefined">
            <p><strong>AWB:</strong> {{ packageData.awb }}</p>
            <p><strong>Created On:</strong> {{ packageData.createdOn }}</p>
            <p><strong>Delivery Address:</strong> {{ packageData.deliveryAddress }}</p>
            <p><strong>Package Email:</strong> {{ packageData.packageEmail }}</p>
            <p><strong>Pay on Delivery:</strong> {{ packageData.payOnDelivery ? 'Yes' : 'No' }}</p>
            <p><strong>Status:</strong> {{ packageData.status }}</p>
            <p><strong>Courier:</strong> {{ packageData.courier ? packageData.courier.name : 'None' }}</p>
        </div>
        <div v-else>
            <p v-if="packageData === null">Loading package data...</p>
            <p v-else="packageData === undefined">No package found with AWB: {{ awb }}</p>
        </div>
    </div>
    <button class="home-btn" :onclick="home">Home</button>
</template>

<script>
import axios from 'axios';

export default {
    name: 'AwbSearch',
    data() {
        return {
            awb: this.$route.query.awb,
            packageData: null
        }
    },
    created() {
        this.fetchPackage();
    },
    methods: {
        home() {
            this.$router.push('/');
        },
        fetchPackage() {
            axios.get(`http://localhost:8083/packages/find`, {
                params: {
                    awb: this.awb
                },
            })
                .then(response => {
                    console.log(response);
                    var pack = response.data[0];
                    console.log(pack);
                    this.packageData = pack;
                })
                .catch(error => {
                    console.error("Error fetching package:", error);
                });
        }
    }
}
</script>