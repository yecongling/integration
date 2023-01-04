/* 头部导航模块 */
import React from "react";
import config from '../../config/global';
import favicon from "../../assets/images/favicon.png";
import {Avatar, Badge, Dropdown, Image, Layout, MenuProps, Space} from "antd";
import {Link} from "react-router-dom";
import Notification from "@layouts/component/notification";
import {BellOutlined, SmileOutlined} from "@ant-design/icons";
const Header: React.FC = () => {

    const items: MenuProps['items'] = [
        {
            key: '1',
            label: (
                <Notification/>
            ),
            icon: <SmileOutlined />,
            disabled: false,
        },
    ]

    return (
        <Layout.Header
            className="ant-layout-header dis-fl jc-sb ai-ct"
            style={{
                padding: '0 16px 0 16px',
                height: '50px',
                borderBottom: ' 1px solid #f0f1f2'
            }}
        >
            <Link to={config.HOME_ROUTER_PATH}>
                <div className="hd-64 mgr-01 dis-fl ai-ct jc-ct">
                    <Image width={25} src={favicon} preview={false}/>
                    <p style={{
                        fontWeight: 'bold',
                        margin: '0 12px',
                        fontSize: '16px',
                        color: 'white'
                    }}>
                        {config.ADMIN_NAME}
                    </p>
                </div>
            </Link>
            <div className="dis-fl js-sb ai-ct">
                <Space>
                    <Dropdown menu={{items}} placement="bottomRight">
                        <div className="login-user"
                             style={{
                                 display: 'flex',
                                 alignItems: 'center',
                                 justifyContent: 'center',
                                 width: 50,
                                 height: 50,
                                 color: 'white',
                                 transition: 'all 0.3s'
                             }}>
                            <Badge count={15}>
                                <BellOutlined style={{verticalAlign: 'middle', color: 'white', cursor: 'pointer'}}></BellOutlined>
                            </Badge>
                        </div>
                    </Dropdown>
                    <Dropdown arrow={false} menu={{items}} placement="bottomCenter">
                        <div className="login-user" style={{
                            display: 'flex',
                            alignItems: 'center',
                            justifyContent: 'center',
                            height: 50,
                            color: 'white',
                            transition: 'all 0.3s'
                        }}>
                            <Avatar size="small" icon={<Image src={favicon}/>}/>
                            <span style={{margin: '0 0 0 10px'}}>叶丛林</span>
                        </div>
                    </Dropdown>
                </Space>

            </div>
        </Layout.Header>
    )
}

export default Header;