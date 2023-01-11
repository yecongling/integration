import React from "react";
import {Layout} from "antd";
import Header from "@layouts/Header";
import "@styles/scss/layout/layout.scss";
import LeftMenu from "@layouts/LeftMenu";
import TagList from "@layouts/TagList";
import Content from "@layouts/Content";
import store from "@/stores";
/* 基础布局 */
const BasicLayout: React.FC = () => {
    const state = store.getState();
    console.log(state)
    return (
        <Layout style={{minHeight: '100%'}}>
            {/* 顶部 */}
            <Header/>
            <Layout>
                {/* 左边菜单 */}
                <LeftMenu/>
                <Layout>
                    <div className="tagsView-container">
                        <TagList/>
                    </div>
                    {/* 中间内容区域 */}
                    <Content/>
                </Layout>
            </Layout>
        </Layout>
    )
}

export default BasicLayout;