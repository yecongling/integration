import React from 'react';
import './App.css';
import {Navigate, Route, Routes} from "react-router-dom";
import {Login} from "./pages/user/Login";
import {Register} from "./pages/user/Register";
import BasicLayout from "@layouts/BasicLayout";

function App() {
    const token = !0;
    return (
        <Routes>
            <Route path="*" element={!token ? <Navigate to="/login"/> : <BasicLayout/>}/>
            <Route path="/login" element={<Login/>}/>
            <Route path="/register" element={<Register/>}/> 
        </Routes>
    );
}

export default App;
