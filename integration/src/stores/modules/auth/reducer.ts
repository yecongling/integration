import {AuthState} from "@/stores/interface";
import {AnyAction} from "redux";
import produce from "immer";
import * as types from "@/stores/mutation-types";
const authState: AuthState = {
    authButtons: {},
    authRouter: []
};

const auth = (state: AuthState = authState, action: AnyAction) =>
    produce(state, draftState => {
        switch (action.type) {
            case types.SET_AUTH_BUTTONS:
                draftState.authButtons = action.authButtons;
                break;
            case types.SET_AUTH_ROUTER:
                draftState.authRouter = action.authRouter;
                break;
            default:
                return draftState;
        }
    });

export default auth;