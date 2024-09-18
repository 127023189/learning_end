const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})
// 配置启动端口
module.exports={
  devServer:{
    host:'localhost',
    port:8001,
    allowedHosts:"all"
  }
}