import SwitchDark from "@/components/common/SwitchDark";
import loginLeft from "@assets/images/login_left.png";
import logo from "@assets/images/logo.png";
import {useNavigate} from "react-router-dom";
import {useState} from "react";
import {Button, Form, Input, Space} from "antd";
import {CloseCircleOutlined, LockOutlined, UserOutlined} from "@ant-design/icons";
import {setToken} from "@/stores/modules/global/action";
import {connect} from "react-redux";
import "./index.less";
import "@/assets/styles/theme/theme-default.less";
import {LoginParams} from "@/services/system/model/userModel";
import {loginApi} from "@/services/system/user/login";

const Login = (props: any) => {
    const {setToken} = props;
    const navigate = useNavigate();
    const [form] = Form.useForm();
    // 加载状态
    const [loading, setLoading] = useState<boolean>(false);

    // 登录
    const onFinish = async (loginForm: LoginParams) => {
        try {
            setLoading(true);
            const {token} = await loginApi(loginForm);
            //  暂时用返回值处理
            setToken(token);
            navigate("/home");
        } finally {
            setLoading(false);
        }
    }

    const onFinishFailed = (error: any) => {
        console.log("登录失败", error);
    }

    return (
        <div className="login-container">
            <SwitchDark/>
            <div className="login-box">
                <div className="login-left">
                    <img src={loginLeft} alt="login"/>
                </div>
                <div className="login-form">
                    <div className="login-logo">
                        <img className="login-icon" src={logo} alt="logo"/>
                        <span className="logo-text">integration</span>
                    </div>
                    {/* from */}
                    <Form
                        form={form}
                        name="basic"
                        labelCol={{span: 5}}
                        initialValues={{remember: true}}
                        onFinish={onFinish}
                        onFinishFailed={onFinishFailed}
                        size="large"
                        autoComplete="off"
                    >
                        <Form.Item name="username" rules={[{required: true, message: "请输入用户名"}]}>
                            <Input autoFocus placeholder="用户名：admin" prefix={<UserOutlined/>}/>
                        </Form.Item>
                        <Form.Item name="password" rules={[{required: true, message: "请输入密码"}]}>
                            <Input.Password autoComplete="new-password" placeholder="密码：123456"
                                            prefix={<LockOutlined/>}/>
                        </Form.Item>
                        <Form.Item className="login-btn">
                            <Space>
                                <Button
                                    onClick={() => {
                                        form.resetFields();
                                    }}
                                    icon={<CloseCircleOutlined/>}
                                >
                                    重置
                                </Button>
                                <Button type="primary" htmlType="submit" loading={loading} icon={<UserOutlined/>}>
                                    登录
                                </Button>
                            </Space>
                        </Form.Item>
                    </Form>
                </div>
            </div>
        </div>
    )
}

const mapDispatcherToProps = {setToken};
export default connect(null, mapDispatcherToProps)(Login);