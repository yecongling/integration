import React from "react";
import {Layout} from "antd";

const {Sider} = Layout;

const LeftMenu: React.FC = () => {
    return (
            <Sider
                trigger={null}
                collapsedWidth={50}
                className="scroll ant-menu"
                style={{
                    overflowX: 'hidden',
                    zIndex: 1000
                }}
                theme={"light"}
                collapsed={false}
                collapsible
            >
                <div className="layout-sider">
                    左边菜单
                </div>

            </Sider>
    )
}

export default LeftMenu;