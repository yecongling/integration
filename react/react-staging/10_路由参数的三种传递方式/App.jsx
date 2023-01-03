import {Component} from "react";
import {NavLink, Route, Routes, Navigate} from "react-router-dom";
import About from './pages/About';
import Home from './pages/Home';
import Header from "./component/Header";
export default class App extends Component {
    render() {
        const a = 12;
        return (
            <div className="container">
                <Header/>
                {/* 在React中靠路由链接实现切换组件 */}
                    <NavLink className="list-group-item" to="/about">About</NavLink>
                    <br/>
                    {/* 向路由组件传递params参数 */}
                    {/*<NavLink className="list-group-item" to={`/home/18/ycl`}>Home</NavLink>*/}
                    {/* 向路由组件传递search参数 */}
                    {/*<NavLink className="list-group-item" to={`/home/18/?id=${a}`}>Home</NavLink>*/}
                    {/* 向路由组件传递state参数 */}
                    <NavLink className="list-group-item" to={{pathname:'/home', state: {id:18, age:15}}}>Home</NavLink>

                <div className="panel">
                    <Routes>
                        {/* 注册路由 react-router-dom V6版本写法 */}
                        <Route path="/about" element={<About/>}/>
                        {/* params参数接收 */}
                        {/*<Route path="/home/:id/:name" element={<Home/>}/>*/}
                        {/* search参数无需接收 */}
                        <Route path="/home" element={<Home/>}/>
                        <Route path="/" element={<Navigate to="/home"/>}/>
                    </Routes>
                </div>
            </div>
        )
    }
}
