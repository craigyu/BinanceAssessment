<template>
  <el-container>
    <el-header class="flex flex-row">
      <Header />
    </el-header>
    <el-container>
      <el-aside class="hidden-md-and-down" width="200px">
        <el-menu active-text-color="#F0B90B" background-color="#2B2F36" class="el-menu-vertical-demo"
          :default-active="activeIndex" text-color="#fff" @select="handleSelect">
          <el-menu-item index="1">
            <span class="text-base font-semibold">Dashboard</span>
          </el-menu-item>
          <el-menu-item index="2">
            <span class="text-base font-semibold">List</span>
          </el-menu-item>
        </el-menu>
      </el-aside>

      <el-container class="overflow-auto">
        <el-main>
          <component :is="currentTab" class="pt-8"></component>
        </el-main>
        <el-footer>
          Footer

        </el-footer>
      </el-container>
    </el-container>
  </el-container>
</template>

<script>
import { defineComponent } from 'vue'
import Table from '@/components/Table'
import Header from '@/components/Header'
import Dashboard from '@/components/Dashboard'

export default defineComponent({
  name: 'Layout',
  components: {
    Table,
    Header,
    Dashboard
  },
  data() {
    return {
      activeIndex: '1',
      currentTab: "Dashboard"
    }
  },
  methods: {
    handleSelect(key) {
      if (key == "1") {
        this.currentTab = 'Dashboard'
      }
      if (key == "2") {
        this.currentTab = "Table"
      }
    }
  }

})
</script>


<style>
.el-container {
  height: 100%;
}

.el-header,
.el-footer {
  background-color: rgb(14, 16, 18);
  color: #fff;
  text-align: center;
  height: 110px;
  line-height: 60px;
}

.el-aside {
  background-color: rgb(39, 41, 47);
  color: #fff;
}

.el-main {
  background-color: #F5F5F5;
  color: #333;
}

.el-menu {
  background-color: rgb(32, 32, 35);
}
</style>
