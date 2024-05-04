<template>
      <div class="contain" >
      <div class="card" >
            <div class="card-body"> 
                <form @submit.prevent="login()">
                <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" v-model="user.email" id="email" class="form-control" placeholder="Enter Email">
                </div>
                <div class="mb-3">
                <label for="pssword" class="form-label">Password</label>
                <input type="text" v-model="user.password" id="pssword" class="form-control" placeholder="Enter password">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>

            </form>
            </div>
        </div>
  
      </div>
</template>
<script>
import axios from 'axios';
export default {
   data() {
    return {
        user: {
            email: '',
            password: ''
        }
    }
   },
   methods: {
    login() {
        axios.post('http://localhost:7000/api/v1/login', this.user).then(res => {
            console.log(res.data.message)
            try{
                if(res.data.message === "Email not Exist"){
                    alert("Email not Exist")
                }else if(res.data.message == "Login Success"){
                   this.$router.push({name: 'home'})
                }
                // else {
                //     alert("Incorrect email and password not match");
                // }
             
            }catch(err){
                alert("Error, Please try again")
            }
        })
    }
   }
}

</script>