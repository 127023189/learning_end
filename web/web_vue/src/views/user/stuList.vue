<template>
  <div id="app">
    <b>学生列表</b>
    <div style="float:right">
        <el-button type="primary" @click="showAddStu" round>添加学生</el-button>
    </div>
    <el-table :data="stuList"
    stripe
    style="width: 100%">
        <el-table-column prop="date" label="日期"></el-table-column>
        <el-table-column prop="name" label="姓名"></el-table-column>
        <el-table-column prop="address" label="地址"></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="props">
            <el-button type="warning" @click="showEditStu(props.row)">编辑</el-button>
            <el-button type="danger" @click="deleteStu(props.row)">删除</el-button>
          </template>
        </el-table-column>
    </el-table>

    <el-dialog title="添加学生信息" :visible.sync="dialogTableVisible4add"
               @close="resetForm('addForm')">
          <el-form :model="formData" :rules="rules" ref="addform" class="demo-ruleForm">
              <el-form-item prop="date" label="日期">
                <el-date-picker type="date" placeholder="选择日期" v-model="formData.date" style="width: 100%;"></el-date-picker>
              </el-form-item>
              <el-form-item prop="name" label="姓名">
                <el-input v-model="formData.name"></el-input>
              </el-form-item>
              <el-form-item prop="address" label="地址">
                <el-input v-model="formData.address"></el-input>
              </el-form-item>
              <el-form-item align="right">
                <el-button type="primary" @click="addStu()">添加</el-button>
                <el-button @click="resetForm('addForm')">重置</el-button>
            </el-form-item>
          </el-form>           
               
    </el-dialog>
  </div>
</template>

<script>
export default {
 name:'App',
 data(){ return {
  formData:{},
  dialogTableVisible4add: false,  //添加窗口显示状态
  stuList:[
            {
              date:"2088-08-08",
              name:"张三",
              address:"上海市航头镇"
            },{
              date:"2088-08-08",
              name:"李四",
              address:"上海市航头镇"
            },{
              date:"2088-08-08",
              name:"王五",
              address:"上海市航头镇"
            },
          ],
        }
      },
      methods:{
      showAddStu(){
        this.dialogTableVisible4add = true;
      },
      resetForm(addForm) {
                //双向绑定，输入的数据都赋值给了formData， 清空formData数据
                this.formData = {};
                //清除表单的校验数据
                this.$refs[addForm].resetFields();
            },
      deleteStu(row){
        const index = this.stuList.indexOf(row);
        if(index > -1){
          this.stuList.splice(index,1);
        }
      }
    }
}
</script>

<style>

</style>