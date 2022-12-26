import React from 'react';
import {LockOutlined, UserOutlined} from '@ant-design/icons';
import {Button, Checkbox, Form, Input} from 'antd';
import {Link} from "react-router-dom";
import styles from "@styles/sass/pages/login.module.scss";

const {login_form} = styles
/* 登录页面 */
export const Login: React.FC = () => {
    const onFinish = (values: any) => {
        console.log('Received values of form: ', values);
    };

    return (
        <Form
            name="normal_login"
            className={`${login_form}`}
            initialValues={{remember: true}}
            onFinish={onFinish}
        >
            <Form.Item
                name="username"
                rules={[{required: true, message: '请输入用户名!'}]}
            >
                <Input prefix={<UserOutlined className="site-form-item-icon"/>} placeholder="Username"/>
            </Form.Item>
            <Form.Item
                name="password"
                rules={[{required: true, message: '请输入密码!'}]}
            >
                <Input
                    prefix={<LockOutlined className="site-form-item-icon"/>}
                    type="password"
                    placeholder="Password"
                />
            </Form.Item>
            <Form.Item>
                <Form.Item name="remember" valuePropName="checked" noStyle>
                    <Checkbox>Remember me</Checkbox>
                </Form.Item>

                <a className="login-form-forgot" href="">
                    忘记密码
                </a>
            </Form.Item>

            <Form.Item>
                <Button type="primary" htmlType="submit" className="login-form-button">
                    登录
                </Button>
                Or <Link to="/register">注册!</Link>
            </Form.Item>
        </Form>
    );
};
