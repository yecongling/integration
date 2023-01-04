import React, {useState} from "react";
import {Layout} from "antd";
import {MenuFoldOutlined, MenuUnfoldOutlined} from "@ant-design/icons";
import AdminConfig from "../../config/global";

const {Sider} = Layout;

const LeftMenu: React.FC = () => {

    const [collapse, setCollapse] = useState(AdminConfig.COLLAPSE);

    const changeCollapse = () => {
        setCollapse(!collapse);
    }

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
            collapsed={collapse}
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
                    onClick={() => changeCollapse()}
                    className="btnbor"
                >
                    <div style={{marginLeft: '16px', padding: '10px 0'}}>
                        {React.createElement(collapse ? MenuUnfoldOutlined : MenuFoldOutlined)}
                    </div>
                </div>
            </div>

        </Sider>
    )
}

export default LeftMenu;