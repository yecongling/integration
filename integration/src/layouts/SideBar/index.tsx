import React from "react";
import MenuBar from "@layouts/MenuBar"
const Index: React.FC<ISharedProps> = ({
    foldMenu,
    collapsed,
    configInfo = {}
}) => {
    return foldMenu ? <MenuBar/> : <h2>测试</h2>
}

export default Index