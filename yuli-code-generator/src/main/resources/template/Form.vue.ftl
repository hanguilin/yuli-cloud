<template>
  <el-dialog :title="title"
             :close-on-click-modal="false"
             v-dialogDrag
             append-to-body
             :visible.sync="visible">
    <el-form :model="inputForm"
             :rules="dataRule"
             v-loading="loading"
             :class="method==='info'?'readonly':''"
             :disabled="method==='info'"
             ref="inputForm"
             @keyup.enter.native="doSubmit()"
             label-width="80px"
             @submit.native.prevent>
      <el-row :gutter="20">
        <#list fieldList as field>
        <el-col :span="12">
          <el-form-item label="${field.comment}"
                        prop="${field.nameLower}">
            <el-input v-model="inputForm.${field.nameLower}"
                      placeholder="${field.comment}"></el-input>
          </el-form-item>
        </el-col>
        </#list>
      </el-row>

    </el-form>
    <span slot="footer"
          class="dialog-footer">
      <el-button @click="visible = false">关闭</el-button>
      <el-button v-if="method != 'info'"
                 type="primary"
                 @click="doSubmit()"
                 v-noMoreClick>确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
export default {
  data () {
    return {
      visible: false,
      loading: false,
      title: '',
      method: '',
      inputForm: {
        <#list fieldList as field>
        ${field.nameLower}: ''${(field_index < (fieldList?size - 1)) ? string(",", "")}
        </#list>
      },
      dataRule: {
      }
    }
  },
  methods: {
    init (method, id) {
      this.method = method
      if (method === 'save') {
        this.title = '新增${comment}'
      } else if (method === 'update') {
        this.title = '编辑${comment}'
      } else if (method === 'info') {
        this.title = '查看${comment}'
      }
      this.visible = true
      this.$nextTick(() => {
        this.$refs.inputForm.resetFields()
        this.inputForm.id = id
        // 修改或者查看
        if (method === 'update' || method === 'info') {
          this.$http.get(`${((gateWayPrefix!"")?length gt 1)?string("/" + gateWayPrefix, "")}/${classNameLower}/info/${r'${this.inputForm.id}'}`).then(({ data }) => {
            if (data && data.code === 200) {
              this.inputForm = this.$util.recover(this.inputForm, data.data)
            }
          })
        }
      })
    },
    // 表单提交
    doSubmit () {
      this.$refs.inputForm.validate((valid) => {
        if (valid) {
          this.loading = true
          let request
          if (this.method === 'update') {
            request = this.$http.put('${((gateWayPrefix!"")?length gt 1)?string("/" + gateWayPrefix, "")}/${classNameLower}/update', this.inputForm)
          } else {
            request = this.$http.post('${((gateWayPrefix!"")?length gt 1)?string("/" + gateWayPrefix, "")}/${classNameLower}/save', this.inputForm)
          }
          request.then(({ data }) => {
            if (data && data.code === 200) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500
              })
              this.visible = false
              this.$emit('refreshDataList')
            }
            this.loading = false
          })
        }
      })
    }
  }
}
</script>
