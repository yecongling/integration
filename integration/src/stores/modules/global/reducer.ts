import {GlobalState} from "@/stores/interface";
import produce from "immer";
import * as types from "@/stores/mutation-types";
import {AnyAction} from "redux";

const globalState: GlobalState = {
    token: "",
    userIndo: "",
    assemblySize: "middle",
    language: "",
    themeConfig: {
        // 默认 primary 主题颜色
        primary: "#1890ff",
        // 深色模式
        isDark: false,
        // 色弱模式(weak) || 灰色模式(gray)
        weakOrGray: "",
        // 面包屑导航
        breadcrumb: true,
        // 标签页
        tabs: true,
        // 页脚
        footer: true
    }
}

/* global reducer */
const global = (state: GlobalState=globalState, action: AnyAction) =>
    produce(state, draftState => {
        switch (action.type) {
            case types.SET_TOKEN:
                draftState.token = action.token
                break
            default:
                return draftState;
        }
    })

export default global