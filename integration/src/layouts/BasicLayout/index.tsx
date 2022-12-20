import React from "react";
import {Layout} from "antd";
import Header from "@layouts/Header";
import SideBar from "@layouts/SideBar";
import "@style/scss/common/layout.scss";
/* 基础布局 */
const Index: React.FC = () => {
    const userInfo = {
        authority: "",
        userId: 2,
        userName: ""
    }
    return (
        <Layout>
            <Header/>
            <SideBar userInfo={userInfo}/>
        </Layout>
    )
}

export default Index;