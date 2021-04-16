import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/components/Main'
import Login from "../components/Login";
import Register from "../components/Register";
import Find from "../components/Find";
import Article from "../components/Article";
import Room from "@/components/Room";
import test from "../components/common/test";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Main',
      component: Main
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Register',
      component:Register
    },
    {
      path: '/find',
      name: 'Find',
      component:Find
    },
    {
      path: '/article/:id',
      name: 'Article',
      component: Article
    },
    {
      path: '/room',
      name: 'Room',
      component: Room
    },
    {
      path: '/test',
      name: test,
      component: test
    }
  ]
})
