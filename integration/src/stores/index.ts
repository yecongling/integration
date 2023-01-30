import {combineReducers, applyMiddleware, legacy_createStore as createStore, Store, compose} from "redux";
import global from "@/stores/modules/global/reducer";
import {persistStore, persistReducer} from "redux-persist";
import storage from "redux-persist/lib/storage";
import thunk from "redux-thunk";
import auth from "@/stores/modules/auth/reducer";
import menu from "@/stores/modules/menu/reducer";
// 创建reducer（拆分reducer）
const reducer = combineReducers({
    global,
    menu,
    auth
})

// redux持久化配置
const persistConfig = {
    key: "redux-state",
    storage: storage
}
const persistReducerConfig = persistReducer(persistConfig, reducer);
const store: Store = createStore(persistReducerConfig, compose(applyMiddleware(thunk)));
// 创建持久化store
const persistor = persistStore(store);
export {store, persistor};