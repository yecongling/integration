import React, {Suspense} from "react";
import {Layout, Spin} from "antd";
import {Navigate, Route, Routes, useLocation} from "react-router-dom";
import AdminConfig from "../../config/global";
import Home from "../../pages/Home";
import Home1 from "../../pages/Home1";
/* 内容区域 */
const Index: React.FC = ()=> {
    const location = useLocation();
    return (
        <Layout.Content className="dis-fl fd-c">
            <Suspense fallback={
                <div className="dis-fl jc-ct ai-ct" style={{ height: '100vh' }}>
                    <Spin size="large" />
                </div>
            }>
                <Routes location={location}>
                    <Route path="/home" element={<Home/>} />
                    <Route path="/home1" element={<Home1/>} />
                    <Route path="/" element={<Navigate to={AdminConfig.HOME_ROUTER_PATH} replace/>}></Route>
                    {/* 注册路由 */}
                </Routes>
            </Suspense>
        </Layout.Content>
    )
}

export default Index;