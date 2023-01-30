import * as types from "@/stores/mutation-types";
import { getMenuList } from "@/services/system/permission/permission";
import { Dispatch } from "react";
import {RouteItem} from "@/services/system/model/menuModel";

// * updateCollapse
export const updateCollapse = (isCollapse: boolean) => ({
	type: types.UPDATE_COLLAPSE,
	isCollapse
});

// * setMenuList
export const setMenuList = (menuList: RouteItem[]) => ({
	type: types.SET_MENU_LIST,
	menuList
});

interface MenuProps {
	type: string;
	menuList: RouteItem[];
}
// * redux-thunk
export const getMenuListActionThunk = () => {
	return async (dispatch: Dispatch<MenuProps>) => {
		const res = await getMenuList();
		dispatch({
			type: types.SET_MENU_LIST,
			menuList: (res as RouteItem[]) ?? []
		});
	};
};

// * redux-promise《async/await》
export const getMenuListAction = async (): Promise<MenuProps> => {
	const res = await getMenuList();
	return {
		type: types.SET_MENU_LIST,
		menuList: (res as RouteItem[]) ?? []
	};
};

// * redux-promise《.then/.catch》
export const getMenuListActionPromise = (): Promise<MenuProps> => {
	return getMenuList().then(res => {
		return {
			type: types.SET_MENU_LIST,
			menuList: (res as RouteItem[]) ?? []
		};
	});
};
