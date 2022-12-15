import React, {Fragment} from 'react';
import './App.css';
import {Button} from "antd";
import Header from "./components/Header";
import Home from "./pages/home/home";

function App() {
  return (
    <Fragment>
        <div className="App">
            <h1>第一个</h1>
        </div>
        <div className="App-Other">
            <h2>第二个</h2>
            <Header/>
        </div>
        <Button type="primary">按钮</Button>
        <Home/>
    </Fragment>
  );
}

export default App;
