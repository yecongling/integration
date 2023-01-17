import React from 'react';
import './App.css';
import {connect} from "react-redux";
import AuthRouter from "@/routes/utils/authRouter";
import Router from "@/routes";
const App = ()=> {
    return (
        <AuthRouter>
            <Router/>
        </AuthRouter>
    );
}
// 将state和组件的属性绑定
const mapStateToProps = (state: any) => state.global;
export default connect(mapStateToProps, null)(App);
