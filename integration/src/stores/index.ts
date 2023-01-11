import {combineReducers, applyMiddleware, legacy_createStore as createStore} from "redux";
import global from "@/stores/modules/global/reducer";
import thunk from "redux-thunk";
// 创建reducer（拆分reducer）
const reducer = combineReducers({
    global
})

export default createStore(reducer, applyMiddleware(thunk));
