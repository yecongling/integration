import React from "react";
import {Layout} from "antd";
import Header from "@layouts/Header";
import SideBar from "@layouts/SideBar";
import "@style/scss/common/layout.scss";
/* 基础布局 */
const BasicLayout: React.FC = () => {
    return (
        <Layout>
            <Header/>
            <SideBar/>
        </Layout>
    )
}

export default BasicLayout;