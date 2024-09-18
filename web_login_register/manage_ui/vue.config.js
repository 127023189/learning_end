const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  // lintOnSave: false
})

module.exports={
  devServer:{
    port:8081,
    host: '127.0.0.1',
    open:true,
    // hotOnly: true,
    proxy:{
      '/': {
        target: 'http://127.0.0.1:8080',  // 后端服务的地址
        changeOrigin: true,
        ws: false
      }
    }
  }
}
