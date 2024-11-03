<script setup lang="ts">
import { ref } from 'vue';
import {RouterView} from 'vue-router'
import {Close, Header, HeaderNav, HeaderNavItem, Toast, Toasts} from "agnostic-vue";
import {activeToasts} from "@/ts/toasts";
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

import 'agnostic-vue/dist/common.min.css';
import "agnostic-vue/dist/index.css";

const isShoopingHovered = ref(false);
const isMealPlanHovered = ref(false);
const isRecipesHovered = ref(false);
const isStatisticsHovered = ref(false);
</script>

<template>
  <div id="app" class="app-container">
    <Header isHeaderContentStart class="header-top">
      <template v-slot:headernav>
       
         hi
          
          
        
      </template>
    </Header>

    <div class="main">
      <RouterView/>
    </div>
  </div>

  <Header isHeaderContentStart class="header-bottom">
    <template v-slot:headernav>
      <HeaderNav class="header-nav">
        <HeaderNavItem class="header-nav-item">
          <RouterLink to="/" class="icon">
            <font-awesome-icon :icon="['fas', 'basket-shopping']" :bounce="isShoopingHovered" 
            @mouseover="isShoopingHovered = true" @mouseleave="isShoopingHovered = false" size="2xl" />
            ShoppingList
          </RouterLink>
        </HeaderNavItem>
        <HeaderNavItem class="header-nav-item">
          <RouterLink to="/mealPlan" class="icon">
            <font-awesome-icon :icon="['fas', 'calendar-days']" size="2xl" 
            :bounce="isMealPlanHovered" 
            @mouseover="isMealPlanHovered = true" @mouseleave="isMealPlanHovered = false"/>
            MealPlan
          </RouterLink>
        </HeaderNavItem>
        <HeaderNavItem class="header-nav-item">
          <RouterLink to="/recipes" class="icon">
            <font-awesome-icon :icon="['fas', 'utensils']" size="2xl" 
            :bounce="isRecipesHovered" 
            @mouseover="isRecipesHovered = true" @mouseleave="isRecipesHovered = false"/>
            Recipes
          </RouterLink>
        </HeaderNavItem>
        <HeaderNavItem class="header-nav-item">
          <RouterLink to="/statistics" class="icon">
            <font-awesome-icon :icon="['fas', 'chart-simple']" size="2xl" 
            :bounce="isStatisticsHovered" 
            @mouseover="isStatisticsHovered = true" @mouseleave="isStatisticsHovered = false"/>
            Statistics
          </RouterLink>
        </HeaderNavItem>
      </HeaderNav>
    </template>
  </Header>

  <Toasts vertical-position="top" horizontal-position="end">
    <template v-for="toast of activeToasts" :key="toast.key">
      <Toast :type="toast.type" class="alert alert-border-left alert-info">
        <div class="flex-fill flex flex-column">
          <div class="flex">
            <h3 class="flex-fill">{{ toast.title }}</h3>
            <Close @click="toast.close()"/>
          </div>
          <div class="flex">
            <font-awesome-icon :icon="toast.icon" size="xl" class="mie8 pbs2"></font-awesome-icon>
            <div class="flex-fill">
              {{ toast.message }}
            </div>
          </div>
        </div>
      </Toast>
      <div class="mbe14"/>
    </template>
  </Toasts>
</template>

<style scoped>
.app-container {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
  overflow: hidden;
}


.header-top {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  background-color: #f8f8f8;
  padding: 10px;
  text-align: center;
  height: 50px; 
  z-index: 10; /* Ensures it stays above the main content */
}

.header-bottom {
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  background-color: #f8f8f8;
  padding: 10px;
  text-align: center;
  height: 80px; 
  z-index: 10; /* Ensures it stays above the main content */
  border-top: none; 
  box-shadow: none;
  display: flex;
  justify-content: center;

}

.main {
  flex-grow: 1;
  padding-top: 50px; 
  padding-bottom: 85px; 
  overflow-y: auto; 
  background-color: #f8f8f8;
}

.header-nav-item {
 padding-left: 175px;
}

.header-nav a:hover {
  transition: color 0.3s ease;
  color: #007BFF; 
  
}

.router-link-active {
  color: #007BFF; 
}

.icon{
  display: flex;
  flex-direction: column;
  align-items: center; 
  text-align: center;
}





</style>
