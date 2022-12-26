import React, {useCallback} from "react";
import styles from '@styles/sass/pages/login.module.scss';
import {Button, Form, Input} from "antd";
import {LockOutlined, UserOutlined} from "@ant-design/icons";
import {Link} from "react-router-dom";
// 登录模块
const {login_form} = styles;
const FormItem = Form.Item;
export const Login: React.FC = () => {
    // 提交函数
    const handleSubmit = useCallback((e: React.MouseEvent<HTMLFormElement>) => {
        console.log("表单提交")
    }, [])

    return (
        <div className={`${login_form} locate-very lr0`}>
            logo
            <Form className="form-wrapper" onSubmitCapture={handleSubmit}>
                <FormItem>
                    <Input
                        autoFocus
                        maxLength={10}
                        required
                        prefix={<UserOutlined className="color-default-gray"/>}
                        suffix={<span className="color-default-gray">用户名</span>}/>
                </FormItem>
                <FormItem>
                    <Input
                        maxLength={20}
                        required
                        prefix={<LockOutlined className="color-default-gray"/>}
                        suffix={<span className="color-default-gray">密码</span>}/>
                </FormItem>
                <Button className="w-100" type="primary" htmlType="submit">登录</Button>
                <FormItem>
                    <h4 style={{display: "flex", textAlign: "center"}}>
                        <Link to="/register">创建账户</Link>
                    </h4>
                </FormItem>
            </Form>
        </div>
    )
}