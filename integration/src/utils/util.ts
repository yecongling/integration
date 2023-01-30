import {RouteItem} from "@/services/system/model/menuModel";

/**
 * @description 使用递归处理路由菜单，生成一维数组，做菜单权限判断
 * @param {Array} routerList 所有菜单列表
 * @param {Array} newArr 菜单的一维数组
 * @return array
 */
export function handleRouter(routerList: RouteItem[], newArr: string[] = []) {
    routerList.forEach((item: RouteItem) => {
        typeof item === "object" && item.path && newArr.push(item.path);
        item.children && item.children.length && handleRouter(item.children, newArr);
    });
    return newArr;
}