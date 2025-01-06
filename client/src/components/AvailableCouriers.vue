<template >

<v-text-field v-model="awb" label="Search AWB" class="awb-input"></v-text-field>

barga

</template> 

<script>
export default {
    name: 'UserRegistration',
    props: {
      msg: String
    },
    data() {
      return {
        name: '',
        email: '',
        password: '',
        repeatPassword: '',
        showToast: false,
        toastMessage: ''
      };
    },
}
</script>