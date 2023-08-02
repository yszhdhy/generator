<script setup lang="ts">
  import { ref, onMounted, reactive } from 'vue'
  import {
    getMenuList,
    reqAddOrUpdateMenu,
    RemoveMenu,
  } from '@/api/system/menu/index.ts'
  import type {
    PermissionResponseData,
    PermissionList,
    Permission,
  } from '@/api/system/menu/type.ts'
  import {ElMessage} from "element-plus";


  let PermissionArr = ref<PermissionList>([])//菜单列表
  let dialogVisible = ref<boolean>(false)
  let typeDisabled=ref<boolean>(false)
  let type0Disabled=ref<boolean>(false)
  let type1Disabled=ref<boolean>(false)
  let type2Disabled=ref<boolean>(false)
  let dataForm=ref<Permission>()
  let menuData = reactive<Permission>({ //上传数据
    id: '',
    parentId: '',
    parentName:'',
    name: '',
    type: 0,
    component: '',
    perms: '',
    icon: '',
    sortValue: 1,
    status: 1,
    path:''
  })
  let iconList=ref<any>([
    {
      class: "Plus",
    },
    {
      class: "CirclePlus",
    },
    {
      class: "Search",
    },
    {
      class: "Service",
    },
    {
      class: "Pointer",
    },
    {
      class: "Star",
    },
    {
      class: "View",
    },
    {
      class: "Bell",
    },
    {
      class: "Refresh",
    },
    {
      class: "Switch",
    },
    {
      class: "Finished",
    },
    {
      class: "Remove",
    },
    {
      class: "Open",
    },
    {
      class: "Tools",
    },
    {
      class: "Grid",
    },
    {
      class: "Avatar",
    },
    {
      class: "Share",
    }])


  onMounted(() => {
    getHasPermission()
  })

  const getHasPermission = async () => {
    let res: PermissionResponseData = await getMenuList()
    if (res.code === 200) {
      PermissionArr.value = res.data
    }
  }

  const addPermission = (row?: Permission) => {
    typeDisabled.value = false
    dialogVisible.value = true
    Object.assign( menuData,{
      id: '',
      parentId: '',
      parentName:'',
      name: '',
      type: 0,
      component: '',
      perms: '',
      icon: '',
      sortValue: 1,
      status: 1,
      path:''
    })
    menuData.id=''
    menuData.parentId=row?.id as string//新建一个菜单将它放在当前目录下
    menuData.parentName=row?.name//父亲菜单
    if(row){
      if(row.type===0){
        menuData.type = row.type + 1
        type2Disabled.value=true
      } else{
        menuData.type = row.type + 1
        typeDisabled.value=true
      }
    }
    else {
      menuData.type=0
      menuData.component='layout/index'
      menuData.parentId=0
      typeDisabled.value=true
    }
  }

  const updatePermission = (row: Permission) => {
    dialogVisible.value = true
    Object.assign(menuData, row)
    typeDisabled.value=true
  }

  const save = async () => {
    dialogVisible.value = false
    let res: any = await reqAddOrUpdateMenu(menuData)
    if (res.code === 200) {
      dialogVisible.value = false
      // eslint-disable-next-line no-undef
      ElMessage({
        type: 'success',
        message: menuData.id='' ?  '添加成功':  '更新成功',
      })
      await getHasPermission()
    }
  }

  const removeMenu = async (id: number) => {//删除菜单
    let res = await RemoveMenu(id)
    if (res.code === 200) {
      // eslint-disable-next-line no-undef
      ElMessage({ type: 'success', message: '删除成功' })
      await  getHasPermission()
    }
  }
</script>
<template>
  <el-card style="margin: 10px 0" >
    <el-button type="primary" size="default"  @click="addPermission()"  >
      添加菜单
    </el-button>
    <el-table
            style="width: 100%;  margin-bottom: 20px; margin-top: 10px"
            row-key="id"
            border
            :data="PermissionArr"
    >
      <el-table-column prop="name" label="名称" />
      <el-table-column prop="perms" label="权限标识" width="160"/>
      <el-table-column prop="path" label="路由地址" width="120"/>
      <el-table-column prop="component" label="组件路径" width="160"/>
      <el-table-column prop="sortValue" label="排序" width="60"/>
      <el-table-column prop="updateTime" label="修改时间" show-overflow-tooltip />
      <el-table-column label="操作" align="center" width="260px">
        <template #="{ row, $index }">
          <el-button
                  size="small"
                  v-if="row.type!==2"
                  @click="addPermission(row)"
          >
            添加菜单
          </el-button>
          <el-button
                  type="primary"
                  size="small"
                  @click="updatePermission(row)"
          >
            编辑
          </el-button>
          <el-popconfirm
                  :title="`你确定要删除${r"${"}row.name${r"}"}?`"
                  width="260px"
                  @confirm="removeMenu(row.id)"
          >
            <template #reference>
              <el-button type="danger" size="small"  :disabled="row.children.length > 0">
                删除
              </el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
  </el-card>
  <el-dialog
          v-model="dialogVisible"
          :title="menuData.id ? '更新菜单' : '添加菜单'"
  >
    <el-form  ref="dataForm"  :model="menuData" label-width="150px" size="small" style="padding-right: 40px;">
      <el-form-item label="上级部门" v-if="menuData.id === ''">
        <el-input v-model="menuData.parentName" :disabled="true"/>
      </el-form-item>
      <el-form-item label="菜单类型" prop="type">
        <el-radio-group v-model="menuData.type" :disabled="typeDisabled">
          <el-radio :label="0" :disabled="type0Disabled">目录</el-radio>
          <el-radio :label="1" :disabled="type1Disabled">菜单</el-radio>
          <el-radio :label="2" :disabled="type2Disabled">按钮</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="菜单名称" prop="name">
        <el-input v-model="menuData.name"/>
      </el-form-item>
      <el-form-item label="图标" prop="icon" v-if="menuData.type !== 2">
        <el-select v-model="menuData.icon" clearable>
          <el-option v-for="item in iconList" :key="item.class" :label="item.class" :value="item.class">
            <!--            <el-icon>-->
            <!--              <component :is="item.class"></component>-->
            <!--            </el-icon>-->
            <!--              <span>{{ item.class }}</span>-->
            <template #title>
              <el-icon>
                <component :is="item.class"></component>
              </el-icon>
              <span>{{ item.class }}</span>
            </template>
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="排序">
        <el-input-number v-model="menuData.sortValue" controls-position="right" :min="0" />
      </el-form-item>
      <el-form-item prop="path" label="路由地址">
        <el-input v-model="menuData.path" placeholder="请输入路由地址" />
      </el-form-item>
      <el-form-item prop="component" label="组件路由" v-if="menuData.type !== 0">
        <el-input v-model="menuData.component" placeholder="请输入组件路径" />
      </el-form-item>
      <el-form-item  prop="perms"  v-if="menuData.type === 2" label="权限字符">
        <el-input v-model="menuData.perms"  placeholder="请输入权限标识" maxlength="100" />

      </el-form-item>
      <el-form-item label="状态" prop="type">
        <el-radio-group v-model="menuData.status">
          <el-radio :label="1">正常</el-radio>
          <el-radio :label="0">停用</el-radio>
        </el-radio-group>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="save">确定</el-button>
      </span>
    </template>
  </el-dialog>
</template>
<style lang="scss" scoped></style>
