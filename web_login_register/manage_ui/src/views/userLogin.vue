<template>
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" class="ruleForm">
    <el-row type="flex" justify="center">
        <el-col :span="6">
            <el-form-item prop="username">
                <el-input type="text" placeholder="请输入用户名" v-model="ruleForm.username" prefix-icon="el-icon-user-solid"></el-input>
            </el-form-item>
        </el-col>
    </el-row>
    <el-row type="flex" justify="center">
        <el-col :span="6">
            <el-form-item prop="password">
                <el-input v-model="ruleForm.password" placeholder="请输入密码" prefix-icon="el-icon-lock"></el-input>
            </el-form-item>
        </el-col>
    </el-row>
    <el-row type="flex" justify="center">
        <el-col :span="4">
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
            </el-form-item>
        </el-col>
    </el-row>
  </el-form>
</template>

<script>
import axios from 'axios'
export default {
    data(){
        return{
            ruleForm:{
                username:'',
                password:''
            },
            rules:{
                username:[
                    {required:true,message:'请输入用户名',trigger:'blur'}],
                password:[
                    {required:true,message:'请输入密码',trigger:'blur'}
                ]
            }
        }
    },
    methods:{
        submitForm(forName){
            this.$refs[forName].validate(valid => {
                if(valid){
                    axios({
                        method:'POST',
                        url:'/login',
                        data:{
                            username:this.ruleForm.username,
                            password:this.ruleForm.password
                        }
                    }).then(response=>{
                        console.log(response);
                        
                        if(response.data){
                            this.$message({
                                message:'登录成功',
                                type:'success'
                            });
                        }else{
                            this.$message.error('登录失败');
                        }
                        
                    }
                    ).finally()
                }else{
                    console.log("表单验证失败");
                    return false;
                }
            })
        }
    }
}
</script>

<style>
.ruleForm {
    margin-top:80px ;
}
</style>