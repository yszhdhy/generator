{
  "name": "tempalte",
  "private": true,
  "version": "0.0.0",
  "type": "module",
  "scripts": {
    "dev": "vite",
    "build": "vue-tsc && vite build",
    "preview": "vite preview",
    "build:test": "vue-tsc && vite build --mode test",
    "build:pro": "vue-tsc && vite build --mode production"
  },
  "dependencies": {
    "@element-plus/icons-vue": "^2.1.0",
    "axios": "^1.4.0",
    "echarts": "^5.4.3",
    "element-plus": "^2.3.8",
    "lodash": "^4.17.21",
    "pinia": "^2.1.4",
    "vue": "^3.3.4",
    "vue-router": "^4.2.4"
  },
  "devDependencies": {
    "@vitejs/plugin-vue": "^4.2.3",
    "nprogress": "^0.2.0",
    "qs": "^6.11.2",
    "sass": "^1.63.6",
    "sass-loader": "^13.2.2",
    "typescript": "^5.0.2",
    "vite": "^4.4.0",
    "vue-tsc": "^1.8.3"
  }
}
