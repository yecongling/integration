/* globalState */
import {SizeType} from "antd/es/config-provider/SizeContext";

export interface IAction {
    type: string,
    data?: any
}

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