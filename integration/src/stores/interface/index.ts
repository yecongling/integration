/* globalState */
import {SizeType} from "antd/es/config-provider/SizeContext";
import {RouteItem} from "@/services/system/model/menuModel";

/* themeConfigProp */
export interface ThemeConfigProp {
    primary: string;
    isDark: boolean;
    weakOrGray: string;
    breadcrumb: boolean;
    tabs: boolean;
    footer: boolean;
}

/* GlobalState */
export interface GlobalState {
    token: string,
    userIndo: any,
    language: string,
    assemblySize: SizeType,
    themeConfig: ThemeConfigProp
}

/* AuthState */
export interface AuthState {
    authButtons: {
        [propName: string]: any;
    };
    authRouter: string[];
}

/* MenuState */
export interface MenuState {
    isCollapse: boolean;
    menuList: RouteItem[];
}