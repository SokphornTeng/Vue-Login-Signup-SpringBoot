<template>
    <div class="container">
        <form @submit.prevent="saveData()">
            <div class="mb-3">
      <label for="firstname" class="form-label">First Name</label>
      <input type="text" v-model="user.firstName" id="firstname" class="form-control" placeholder="Enter FirstName">
    </div>
    <div class="mb-3">
      <label for="lastname" class="form-label">Last Name</label>
      <input type="text" v-model="user.lastName" id="lastname" class="form-control" placeholder="Enter LastName">
    </div>
    <div class="mb-3">
      <label for="email" class="form-label">Email</label>
      <input type="email" v-model="user.email" id="email" class="form-control" placeholder="Enter Email">
    </div>
    <div class="mb-3">
      <label for="pssword" class="form-label">Password</label>
      <input type="password" v-model="user.password"  id="pssword" class="form-control" placeholder="Enter password">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
    </div>
</template>
<script>
import axios from 'axios';
export default {
   data() {
    return {
        user: {
            firstName: '',
            lastName: '',
            email: '',
            password: ''
        }
    }
   },
   methods: {
    saveData() {
        axios.post('http://localhost:7000/api/v1/add', this.user).then(res => {
            console.log(res.data)
            try{
                alert("Sign up successfully")
            }
            catch(err){
                alert("Failed")
            }
        })
    }
   }
}

</script>