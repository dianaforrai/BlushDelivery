<template >


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