import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import '@styles/scss/global.scss';
import App from "./App";
import {BrowserRouter} from "react-router-dom";
import {ConfigProvider} from "antd";
import {Provider} from "react-redux";
import store from "@/stores"
const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <React.StrictMode>
      <ConfigProvider>
          <Provider store={store}>
              <BrowserRouter>
                  <App />
              </BrowserRouter>
          </Provider>
      </ConfigProvider>
  </React.StrictMode>
);
