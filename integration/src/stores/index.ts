import {combineReducers} from "redux";
import global from "@/stores/modules/global/reducer";
// 创建reducer（拆分reducer）
const reducer = combineReducers({
    global
})

