/**
 * 路由
 */
import {RouteItem} from "/#/router";
import {Navigate, useRoutes} from "react-router-dom";
import BasicLayout from "@layouts/BasicLayout";
import Home from "@/pages/Home";
import Login from "@/pages/user/Login";
import Home1 from "@/pages/Home1";

export const rootRouter: RouteItem[] = [
    {
        path: "/",
        element: <Navigate to="/login" />
    },
    {
        path: "/login",
        element: <Login />,
        meta: {
            requiresAuth: false,
            title: "登录页",
            key: "login"
        }
    },
    {
        element: <BasicLayout />,
        children: [
            {
                path: "/index/home",
                element: <Home/>,
                meta: {
                    title: "首页",
                    key: "home"
                }
            },
            {
                path: "/index/home1",
                element: <Home1/>,
                meta: {
                    title: "首页2",
                    key: "home2"
                }
            }
        ]
    }
];

const Router = ()=> {
    return useRoutes(rootRouter);
};
export default Router;