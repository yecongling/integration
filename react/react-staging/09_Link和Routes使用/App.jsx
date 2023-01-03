import {Component} from "react";
import {NavLink, Route, Routes, Navigate} from "react-router-dom";
import About from './pages/About';
import Home from './pages/Home';
import Header from "./component/Header";
export default class App extends Component {
    render() {
        return (
            <div className="container">
                <Header/>
                {/* 在React中靠路由链接实现切换组件 */}
                    <NavLink className="list-group-item" to="/about">About</NavLink>
                    <br/>
                    <NavLink className="list-group-item" to="/home">Home</NavLink>

                <div className="panel">
                    <Routes>
                        {/* 注册路由 */}
                        <Route path="/about" element={<About/>}/>
                        <Route path="/home" element={<Home/>}/>
                        <Route path="/" element={<Navigate to="/home"/>}/>
                    </Routes>
                </div>
            </div>
        )
    }
}
