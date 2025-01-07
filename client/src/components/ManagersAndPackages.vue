<template>
    <div class="container-flowup">
        <table class="table table-striped pink-table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Number of packages</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="manager in managers" :key="manager.id">
                    <th scope="row">{{ manager.id }}</th>
                    <td>{{ manager.name }}</td>
                    <td>{{ manager.email }}</td>
                    <td>{{ manager.numberOfPackages }}</td>
                </tr>
            </tbody>
        </table>
    </div>
    <button class="home-btn" :onclick="home">Home</button>
</template>

<script>
import axios from 'axios';

export default {
    name: 'ManagersAndPackages',
    data() {
        return {
            managers: [],
        }
    },
    created() {
        this.fetchManagers();
    },
    methods: {
        home() {
            this.$router.push('/');
        },
        fetchManagers() {
            axios.get(`http://localhost:8083/couriers/delivered-by-managers`)
                .then(response => {
                    console.log(response);
                    const transformedData = response.data.map(item => ({
                        id: item[0],
                        name: item[1],
                        email: item[2],
                        numberOfPackages: item[3]
                    }));
                    this.managers = transformedData;
                })
                .catch(error => {
                    console.error("Error fetching data:", error);
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