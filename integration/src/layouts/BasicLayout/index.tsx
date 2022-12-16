import React from "react";
import {Layout} from "antd";
import Header from "../../components/Header";
/* 基础布局 */
const Index: React.FC = ()=> {
    return (
        <Layout style={{minHeight: "100%"}}>
            <Header/>
        </Layout>
    )
}

export default Index;