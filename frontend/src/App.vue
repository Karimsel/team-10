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

let name = " ";

const filter = () => {
  
  console.log("Here Dropdown to filter");
}

</script>

<template>
  <div id="app" class="app-container">
    <Header isHeaderContentStart class="header-top">
      <template v-slot:headernav>
        <div class="logo-container">
          <div class="logo">AEB</div>
          <div class="name">ShopScript</div> 
        </div>
        <div class="header-nav-content">
          <input type="text" class="searchbar" v-model="name"/>
          <div class="search-icon">
            <font-awesome-icon :icon="['fas', 'magnifying-glass']" size="2xl" style="color: #f5f5f5;" class="searchicon"/>
            <button class="filter-button" @click="filter">
              <font-awesome-icon :icon="['fas', 'filter']" size="2xl" style="color: #f5f5f5;"/>
            </button>
          </div>
        </div>
      </template>
    </Header>

    <div class="main">
      <RouterView/>
    </div>
  </div>

  <div isHeaderContentStart class="sidebar">
    
      <div class="sidebar-nav">
        <div class="sidebar-nav-item">
          <RouterLink to="/" class="icon">
            <font-awesome-icon :icon="['fas', 'basket-shopping']" :bounce="isShoopingHovered" 
            @mouseover="isShoopingHovered = true" @mouseleave="isShoopingHovered = false" size="2xl" />
            ShoppingList
          </RouterLink>
        </div>
        <div class="sidebar-nav-item">
          <RouterLink to="/mealPlan" class="icon">
            <font-awesome-icon :icon="['fas', 'calendar-days']" size="2xl" 
            :bounce="isMealPlanHovered" 
            @mouseover="isMealPlanHovered = true" @mouseleave="isMealPlanHovered = false"/>
            MealPlan
          </RouterLink>
        </div>
        <div class="sidebar-nav-item">
          <RouterLink to="/recipes" class="icon">
            <font-awesome-icon :icon="['fas', 'utensils']" size="2xl" 
            :bounce="isRecipesHovered" 
            @mouseover="isRecipesHovered = true" @mouseleave="isRecipesHovered = false"/>
            Recipes
            
          </RouterLink>
        </div>
        <div class="sidebar-nav-item">
          <RouterLink to="/statistics" class="icon">
            <font-awesome-icon :icon="['fas', 'chart-simple']" size="2xl" 
            :bounce="isStatisticsHovered" 
            @mouseover="isStatisticsHovered = true" @mouseleave="isStatisticsHovered = false"/>
            Statistics
          </RouterLink>
        </div>
      </div>
    
    </div>

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
  display: flex; 
  justify-content: center; 
  align-items: center;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  background-color: #52a5ff; 
  padding: 20px;
  text-align: center;
  height: 75px; 
  overflow: hidden;
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
}

.header-nav-content {
  display: flex; 
  padding: 250px; 
}

.sidebar {
  position: fixed;
  top: 80px; 
  left: 0;
  width: 150px; 
  background-color: #f8f8f8;
  padding: 20px 10px;
  display: flex;
  flex-direction: column; 
  border-right: none;
}

.main {
  flex-grow: 1;
  padding-top: 80px; 
  padding-left: 160px; 
  overflow-y: auto; 
  background-color: #f8f8f8;
}
.sidebar-nav {
  display: flex;
  flex-direction: column; 
  
}


.sidebar-nav a:hover {
  transition: color 0.3s ease;
  color: #007BFF; 
  
}

.sidebar-nav-item{
  padding-bottom: 50px;
  padding-top: 20px;
}

.router-link-active {
  color: #1E3050;
}

.icon{
 
  display: flex;
  flex-direction: column;
  align-items: center; 
  text-align: center;
}

.searchbar{
  width: 500px;
  border-radius: 50px;
  border: none;
  font-size: 16px;
  
}
.logo-container {
  display: flex;
  flex-direction: column; 
  align-items: center; 
 
}

.logo{
  color: #f5f5f5;
  font-size: 25px;
  font-family: Arial, sans-serif;
  
}
.name {
  font-size: 20px; 
  color: #f5f5f5;  
}
.searchicon{
  padding-left: 5px;
}

.filter-button {
  background: none; 
  border: none; 
  cursor: pointer; 
  padding: 0; 
}

.filter-button:focus {
  outline: none; 
}
</style>
