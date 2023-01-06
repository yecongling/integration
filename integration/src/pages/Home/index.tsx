import React from "react";
import {Button, ConfigProvider} from "antd";
import {useNavigate} from "react-router-dom";

const Index: React.FC = () => {
    const navigation = useNavigate();
    return (
        <div className="dis-fl jc-sb fd-c">
            <div style={{
                width: '500px',
                fontSize: '80px',
                fontWeight: 'bold',
                position: 'absolute',
                left: '50%',
                top: '50%',
                transform: 'translate(-10%, -10%)'
            }}>
                <p>这是主页</p>
                <Button type="primary" onClick={() => {
                    ConfigProvider.config({
                        theme: {
                            primaryColor: '#25b864'
                        }
                    })
                    navigation("/home1")
                }}>去第二个home页面</Button>
            </div>
        </div>
    )
};

export default Index;
