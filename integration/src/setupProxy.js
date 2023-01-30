const {createProxyMiddleware} = require('http-proxy-middleware')

module.exports = function (app) {
    app.use(
        createProxyMiddleware('/userApi', { //遇见/userApi，就会触发该代理
            target: 'http://localhost:8082', // 请求发给谁
            changeOrigin: true, //控制服务器收到的请求头中Host的值
            pathRewrite: {
                '^/userApi': '' // 重写请求路径
            }
        }),
        createProxyMiddleware('/permissionApi', { //遇见/permissionApi，就会触发该代理
            target: 'http://localhost:8082', // 请求发给谁
            changeOrigin: true, //控制服务器收到的请求头中Host的值
            pathRewrite: {
                '^/permissionApi': '' // 重写请求路径
            }
        }),
    )
}