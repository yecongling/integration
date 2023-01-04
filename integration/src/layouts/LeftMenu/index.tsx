import React from "react";
import {Layout} from "antd";
import {MenuFoldOutlined} from "@ant-design/icons";

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
                <div className="pro-sider scroll">
                    菜单
                </div>
                <div
                    style={{
                        width: '100%',
                        cursor: 'pointer',
                        fontSize: '16px',
                        borderTop: '1px solid #ccc',
                        borderRight: '1px solid #f0f2f5'
                    }}
                    onClick={() => {
                    }}
                    className="btnbor"
                >
                    <div style={{marginLeft: '16px', padding: '10px 0'}}>
                        {React.createElement(MenuFoldOutlined)}
                    </div>
                </div>
            </div>

        </Sider>
    )
}

export default LeftMenu;