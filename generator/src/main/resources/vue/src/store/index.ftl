import Vue from 'vue'
import Vuex from 'vuex'
import getters from './getters.js'
import app from './modules/app.js'
import settings from './modules/settings.js'
import user from './modules/user.js'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    app,
    settings,
    user
  },
  getters
})

export default store
