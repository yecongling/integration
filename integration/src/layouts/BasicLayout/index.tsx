import React from "react";
import {Layout} from "antd";
import Header from "@/components/Header";
import Home from "@/pages/Home";
/* 基础布局 */
const Index: React.FC = () => {
    return (
        <Layout style={{minHeight: "100%"}}>
            <Header/>
            <Home/>
        </Layout>
    )
}

export default Index;