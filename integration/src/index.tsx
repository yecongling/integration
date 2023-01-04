import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import '@styles/scss/global.scss';
import App from "./App";
import {BrowserRouter} from "react-router-dom";
import {ConfigProvider} from "antd";
const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <React.StrictMode>
      <ConfigProvider>
          <BrowserRouter>
              <App />
          </BrowserRouter>
      </ConfigProvider>
  </React.StrictMode>
);
