import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import '@styles/scss/global.scss';
import App from "./App";
import {BrowserRouter} from "react-router-dom";
import {ConfigProvider} from "antd";
import {PersistGate} from "redux-persist/integration/react";
import {Provider} from "react-redux";
import {store, persistor} from "@/stores"

const root = ReactDOM.createRoot(
    document.getElementById('root') as HTMLElement
);
root.render(
    <ConfigProvider>
        <Provider store={store}>
            <PersistGate persistor={persistor}>
                <BrowserRouter>
                    <App/>
                </BrowserRouter>
            </PersistGate>
        </Provider>
    </ConfigProvider>
);
