import React from 'react';
import './App.css';
import {Navigate, Route, Routes} from "react-router-dom";
import Login from "./pages/user/Login";
import {Register} from "./pages/user/Register";
import BasicLayout from "@layouts/BasicLayout";
import {store, persistor} from "@/stores";
import {connect} from "react-redux";
const App = ()=> {
    const state = store.getState();
    const token = state.global.token;
    return (
        <Routes>
            <Route path="*" element={!token ? <Navigate to="/login" replace/> : <BasicLayout/>}/>
            <Route path="/login" element={<Login/>}/>
            <Route path="/register" element={<Register/>}/>
        </Routes>
    );
}
// 将state和组件的属性绑定
const mapStateToProps = (state: any) => state.global;
export default connect(mapStateToProps, null)(App);
