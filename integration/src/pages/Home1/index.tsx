import React from "react";
import {Button} from "antd";
import {useNavigate} from "react-router-dom";

const Home1: React.FC = ()=> {
    const navigation = useNavigate();

    return (
        <div>
            这是第二个home页面
            <Button type="primary" onClick={()=> {
                navigation("/index/home");
            }}>回到第一个home页面</Button>
        </div>
    )
}

export default Home1;