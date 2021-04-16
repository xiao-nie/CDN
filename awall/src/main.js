// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from "axios";
import { library } from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import { faHome } from '@fortawesome/free-solid-svg-icons';
import { faUser } from '@fortawesome/free-solid-svg-icons';
import { faEnvelope } from '@fortawesome/free-solid-svg-icons';
import { faCog } from '@fortawesome/free-solid-svg-icons';
import { faLaugh } from '@fortawesome/free-solid-svg-icons';
import { faImage } from '@fortawesome/free-solid-svg-icons';
import { faVideo } from '@fortawesome/free-solid-svg-icons';
import { faThumbsUp } from '@fortawesome/free-solid-svg-icons';
import { faSyncAlt } from '@fortawesome/free-solid-svg-icons';
import { faKey } from '@fortawesome/free-solid-svg-icons';
import { faSignature } from '@fortawesome/free-solid-svg-icons';
import Cookies from 'js-cookie'
library.add(
  faHome,faUser,faEnvelope,faCog,faLaugh,faImage,faVideo,faThumbsUp,faSyncAlt,faKey,faSignature
);
Vue.component('font-awesome-icon',FontAwesomeIcon);
axios.defaults.withCredentials=true;
Vue.prototype.$cookies = Cookies
Vue.prototype.$http = axios;
// Vue.prototype.stringify = require('qs').stringify;
Vue.config.productionTip = false;
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
