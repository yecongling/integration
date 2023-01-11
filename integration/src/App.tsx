import React from 'react';
import './App.css';
import {Navigate, Route, Routes} from "react-router-dom";
import Login from "./pages/user/Login";
import {Register} from "./pages/user/Register";
import BasicLayout from "@layouts/BasicLayout";
import store from "@/stores";
const App = ()=> {
    const state = store.getState();
    const token = !0;
    console.log(state)
    return (
        <Routes>
            <Route path="*" element={!token ? <Navigate to="/login" replace/> : <BasicLayout/>}/>
            <Route path="/login" element={<Login/>}/>
            <Route path="/register" element={<Register/>}/> 
        </Routes>
    );
}

export default App;
