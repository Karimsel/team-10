<script setup lang="ts">
import {RouterView} from 'vue-router'
import {Close, Header, HeaderNav, HeaderNavItem, Toast, Toasts} from "agnostic-vue";
import {activeToasts} from "@/ts/toasts";

import 'agnostic-vue/dist/common.min.css';
import "agnostic-vue/dist/index.css";
</script>

<template>
  <div id="app">
    <Header isHeaderContentStart class="header-top">
      <template v-slot:headernav>
        <HeaderNav>
          <HeaderNavItem>
            <RouterLink to="/">ShoppingList</RouterLink>
          </HeaderNavItem>
          <HeaderNavItem>
            <RouterLink to="/mealPlan">MealPlan</RouterLink>
          </HeaderNavItem>
          <HeaderNavItem>
            <RouterLink to="/recipes">Recipes</RouterLink>
          </HeaderNavItem>
          <HeaderNavItem>
            <RouterLink to="/statistics">Statistics</RouterLink>
          </HeaderNavItem>
        </HeaderNav>
      </template>
    </Header>

    <div class="main">
      <RouterView/>
    </div>
  </div>

  <Header isHeaderContentStart class="header-bottom">
    <template v-slot:headernav>
      <HeaderNav>
        <HeaderNavItem>
          <RouterLink to="/">ShoppingList</RouterLink>
        </HeaderNavItem>
        <HeaderNavItem>
          <RouterLink to="/mealPlan">MealPlan</RouterLink>
        </HeaderNavItem>
        <HeaderNavItem>
          <RouterLink to="/recipes">Recipes</RouterLink>
        </HeaderNavItem>
        <HeaderNavItem>
          <RouterLink to="/statistics">Statistics</RouterLink>
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

.header-top {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

.main {
  flex:1;
}

.header-bottom {
  margin-top: auto; /* Verschiebt den unteren Header ans Seitenende */
  width: 100%;
  background-color: #f8f9fa; /* Optional: Hintergrundfarbe für den unteren Header */
  border-top: 1px solid #dee2e6; /* Optional: obere Linie für den unteren Header */
  padding: 10px;
}
</style>
