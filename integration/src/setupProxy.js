const {createProxyMiddleware} = require('http-proxy-middleware')

module.exports = function (app) {
    app.use(
        createProxyMiddleware('/sys', { //遇见/api1前缀的请求，就会触发该代理
            target: 'http://localhost:8082', // 请求发给谁
            changeOrigin: true, //控制服务器收到的请求头中Host的值
            pathRewrite: {
                '^/sys': '/integration/sys' // 重写请求路径
            }
        })
    )
}