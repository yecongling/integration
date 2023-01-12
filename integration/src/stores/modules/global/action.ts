/* 全局状态操作action */
import * as types from "@/stores/mutation-types";
import {ThemeConfigProp} from "@/stores/interface";

// setToken (返回的是一个对象)
export const setToken = (token: string) => ({
    type: types.SET_TOKEN,
    token
})

// setThemeConfig
export const setThemeConfig = (themeConfig: ThemeConfigProp) => ({
    type: types.SET_THEME_CONFIG,
    themeConfig
})