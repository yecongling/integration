/* 头部导航模块 */
import React from "react";
import {Layout} from "antd";

interface IHeaderProps {
    routes: IRouteItem[]
}

const {Header} = Layout

const Index: React.FC = ()=> {
    return (
        <Header>
            <h2>这是表头</h2>
        </Header>
    )
}

export default Index;