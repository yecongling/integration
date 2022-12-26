import React from 'react';
import './App.css';
import {Navigate, Route, Routes} from "react-router-dom";
import {Login} from "./pages/user/Login";

function App() {
    return (
        <div>
            <Routes>
                <Route path="/login" element={<Login/>}/>
                <Route path="/" element={<Navigate to="/login"/>}/>
            </Routes>
        </div>
    );
}

export default App;
