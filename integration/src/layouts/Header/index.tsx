/* 头部导航模块 */
import React, {useState} from "react";
import config from '../../config/global';
import favicon from "../../assets/images/favicon.png";
import {Avatar, Badge, Dropdown, Image, Layout, MenuProps, Space, Modal} from "antd";
import {useNavigate} from "react-router-dom";
import {Link} from "react-router-dom";
// import Notification from "@layouts/component/notification";
import {
    BellOutlined,
    ExclamationCircleOutlined,
    LogoutOutlined,
    SettingOutlined,
    UserOutlined
} from "@ant-design/icons";
import Setting from "@layouts/Setting";
const Header: React.FC = () => {
    const [open, setOpen] = useState(false);
    const [modal, contextHolder] = Modal.useModal();
    const navigate = useNavigate()
    const items: MenuProps['items'] = [
        {
            key: '1',
            label: '个人中心',
            icon: <UserOutlined/>,
            disabled: false
        },
        {
            key: '2',
            label: '系统设置',
            icon: <SettingOutlined/>,
            disabled: false,
            onClick: function () {
                setOpen(!open);
            }
        },
        {
            key: '3',
            label: '退出登录',
            icon: <LogoutOutlined />,
            disabled: false,
            onClick: function () {
                modal.confirm({
                    title: 'Confirm',
                    icon: <ExclamationCircleOutlined />,
                    content: '确认退出登录吗？',
                    okText: '确认',
                    onOk: function () {
                        // 退出到登录页面
                        navigate("/login");
                    },
                    cancelText: '取消',
                });
            }
        },
    ]

    /**
     * 开关设置界面
     *
     */
    const changeSetting = ()=> {
        setOpen(!open);
    }

    /**
     * 改变抽屉
     * @param val
     */
    const change = (val: boolean)=> {
        setOpen(val);
    }

    return (
        <>
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
                    <Space style={{cursor: 'pointer'}} size="middle">
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
                                    <BellOutlined style={{verticalAlign: 'middle', color: 'white', cursor: 'pointer', padding: '4px'}}/>
                                </Badge>
                            </div>
                        </Dropdown>
                        <SettingOutlined  style={{verticalAlign: 'middle', color: 'white', cursor: 'pointer'}} title="系统设置" onClick={changeSetting}/>
                        <Dropdown menu={{items}} placement="bottom">
                            <div className="login-user" style={{
                                display: 'flex',
                                alignItems: 'center',
                                justifyContent: 'center',
                                height: 50,
                                color: 'white',
                                transition: 'all 0.3s'
                            }}>
                                <Avatar size="small" icon={<UserOutlined/>}/>
                                <span style={{margin: '0 0 0 6px'}}>叶丛林</span>
                            </div>
                        </Dropdown>
                    </Space>

                </div>
            </Layout.Header>
            {/* 系统设置 */}
            <Setting open={open} change={change}/>
            {contextHolder}
        </>
    )
}

export default Header;