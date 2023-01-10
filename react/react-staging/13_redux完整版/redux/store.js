/*
* 该文件专门用于暴露一个store对象，整个应用只有一个store对象
*
* */

/* 引入 createStore，专门用于创建store的*/
import {legacy_createStore as createStore} from "redux";
// 引入为count组件服务的reducer
import countReducer from './counr_reducer';
// 暴露store
export default createStore(countReducer)