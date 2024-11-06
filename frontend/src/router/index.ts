import { createRouter, createWebHashHistory } from 'vue-router'
import ShoppingListView from '../views/ShoppingListView.vue'
import RecipesView from "@/views/RecipesView.vue";
import MealPlanView from "@/views/MealPlanView.vue";
import StatisticsView from "@/views/StatisticsView.vue";

const router = createRouter({
  history: createWebHashHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'shoppingList',
      component: ShoppingListView
    },
    {
      path: '/recipes',
      name: 'recipes',
      component: RecipesView
    },
    {
      path: '/mealPlan',
      name: 'mealPlan',
      component: MealPlanView
    },
    {
      path: '/statistics',
      name: 'Statistics',
      component: StatisticsView
    }
  ]
})

export default router
