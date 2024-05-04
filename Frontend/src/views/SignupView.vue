<template>
    <div class="home">
      <signup-page />
    </div>
  </template>
  
  <script>
  import SignupPage from '@/components/SignupPage.vue'
  
  export default {
    name: 'HomeView',
    components: {
        SignupPage
    }
  }
  </script>
  