<template>
  <div>
    <el-form :inline="true"
             v-show="isSearchCollapse"
             class="query-form"
             ref="searchForm"
             :model="searchForm"
             @keyup.enter.native="refreshList()"
             @submit.native.prevent>

      <el-form-item>
        <el-button type="primary"
                   @click="refreshList()"
                   size="small">查询</el-button>
        <el-button @click="resetSearch()"
                   size="small">重置</el-button>
      </el-form-item>
    </el-form>
    <el-row>
      <el-button
                 v-if="hasPermission('${moduleName!}:${classNameLower!}:save')"
                 type="primary"
                 size="small"
                 icon="el-icon-plus"
                 @click="add()">新建</el-button>
      <el-button
                 v-if="hasPermission('${moduleName!}:${classNameLower!}:update')"
                 type="warning"
                 size="small"
                 icon="el-icon-edit-outline"
                 @click="update()"
                 :disabled="dataListSelections.length !== 1"
                 plain>修改</el-button>
      <el-button
                 v-if="hasPermission('${moduleName!}:${classNameLower!}:delete')"
                 type="danger"
                 size="small"
                 icon="el-icon-delete"
                 @click="delete()"
                 :disabled="dataListSelections.length <= 0"
                 plain>删除
      </el-button>
      <el-button-group class="pull-right">
        <el-tooltip class="item"
                    effect="dark"
                    content="搜索"
                    placement="top">
          <el-button type="default"
                     size="small"
                     icon="el-icon-search"
                     @click="isSearchCollapse = !isSearchCollapse, isImportCollapse=false">
          </el-button>
        </el-tooltip>
        <el-tooltip class="item"
                    effect="dark"
                    content="刷新"
                    placement="top">
          <el-button type="default"
                     size="small"
                     icon="el-icon-refresh"
                     @click="refreshList">
          </el-button>
        </el-tooltip>
      </el-button-group>
    </el-row>
    <el-table :data="dataList"
              v-loading="loading"
              border
              size="medium"
              @selection-change="selectionChangeHandle"
              class="table">
      <el-table-column type="selection"
                       header-align="center"
                       align="center"
                       width="50">
      </el-table-column>
      <#list fieldList as field>
      <el-table-column prop="${field.nameLower}"
                       label="${field.comment}">
      </el-table-column>
      </#list>
      <el-table-column fixed="right"
                       header-align="center"
                       align="center"
                       width="250"
                       label="操作">
        <template slot-scope="scope">
          <el-button
                     v-if="hasPermission('${moduleName!}:${classNameLower!}:info')"
                     type="text"
                     size="small"
                     @click="info(scope.row.id)">查看
          </el-button>
          <el-divider direction="vertical"></el-divider>
          <el-button
                     v-if="hasPermission('${moduleName!}:${classNameLower!}:update')"
                     type="text"
                     size="small"
                     @click="update(scope.row.id)">修改
          </el-button>
          <el-divider direction="vertical"></el-divider>
          <el-button
                     v-if="hasPermission('${moduleName!}:${classNameLower!}:delete')"
                     type="text"
                     size="small"
                     @click="delete(scope.row.id)">
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination @size-change="sizeChangeHandle"
                   @current-change="currentChangeHandle"
                   :current-page="current"
                   :page-sizes="[10, 20, 50, 100]"
                   :page-size="size"
                   :total="total"
                   background
                   layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>

    <!-- 增、改、查 -->
    <${className}Form ref="${classNameLower}Form"></${className}Form>

  </div>
</template>

<script>
import ${className}Form from './${className}Form'

export default {
  data () {
    return {
      searchForm: {
      },
      dataList: [],
      current: 1,
      size: 10,
      total: 0,
      orderBy: '',
      dataListSelections: [],
      isSearchCollapse: false,
      loading: false
    }
  },
  components: {
    ${className}Form
  },
  activated () { },
  mounted () {
    this.refreshList()
  },
  methods: {
    // 获取数据列表
    refreshList () {
      this.loading = true
      this.$http.get('${(gateWayPrefix??)?string("", gateWayPrefix)}/${moduleName}/${classNameLower}/page', {
        params: {
          current: this.current,
          size: this.size
        }
      }).then(({ data }) => {
        if (data && data.code === 200) {
          this.dataList = data.data.records
          this.total = data.data.total
          this.loading = false
        }
      })
    },
    // 每页数
    sizeChangeHandle (val) {
      this.size = val
      this.current = 1
      this.refreshList()
    },
    // 当前页
    currentChangeHandle (val) {
      this.current = val
      this.refreshList()
    },
    // 多选
    selectionChangeHandle (val) {
      this.dataListSelections = val
    },
    // 新增
    add () {
      this.$refs.${classNameLower}Form.init('add', '')
    },
    // 修改
    update (id) {
      id = id || this.dataListSelections.map(item => {
        return item.id
      })[0]
      this.$refs.${classNameLower}Form.init('update', id)
    },
    // 查看
    info (id) {
      this.$refs.${classNameLower}Form.init('info', id)
    },
    // 删除
    delete (id) {
      const ids = id || this.dataListSelections.map(item => {
        return item.id
      }).join(',')
      this.$confirm('确定删除所选项吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$http.delete('${(gateWayPrefix??)?string("", gateWayPrefix)}/${moduleName}/${classNameLower}/delete', { params: { ids } }).then(({ data }) => {
          if (data && data.code === 200) {
            this.$message.success(data.msg)
            this.refreshList()
          }
        })
      })
    },
    resetSearch () {
      this.$refs.searchForm.resetFields()
      this.refreshList()
    }
  }
}
</script>
