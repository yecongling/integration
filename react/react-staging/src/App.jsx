import {Component} from "react";
import {Link, Route, Routes} from "react-router-dom";
import About from './component/About';
import Home from './component/Home';
export default class App extends Component {
    render() {
        return (
            <div className="container">
                {/* 在React中靠路由链接实现切换组件 */}
                    <Link className="list-group-item" to="/about">About</Link>
                    <br/>
                    <Link className="list-group-item" to="/home">Home</Link>

                <div className="panel">
                    <Routes>
                        {/* 注册路由 */}
                        <Route path="/about" element={<About/>}/>
                        <Route path="/" element={<About/>}/>
                        <Route path="/home" element={<Home/>}/>
                    </Routes>
                </div>
            </div>
        )
    }
}
