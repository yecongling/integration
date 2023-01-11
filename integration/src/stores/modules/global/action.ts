/* 全局状态操作action */
import * as types from "@/stores/mutation-types";

// setToken
export const setToken = (token: string) => ({
    type: types.SET_TOKEN,
    token
})