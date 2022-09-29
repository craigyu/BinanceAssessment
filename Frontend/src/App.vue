<template>
  <el-config-provider :size="size" :z-index="zIndex">
    <Layout />
  </el-config-provider>
</template>

<script>

import { defineComponent } from 'vue'
import { ElConfigProvider } from 'element-plus'
import Layout from './containers/Layout'

export default defineComponent({
  name: 'App',
  components: {
    Layout,
    ElConfigProvider,
  },
  setup() {
    return {
      zIndex: 3000,
      size: 'small',
    }
  },
})
</script>

<style>
html,
body,
#app {
  height: 100%;
  margin: 0px;
  padding: 0px;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}
</style>
