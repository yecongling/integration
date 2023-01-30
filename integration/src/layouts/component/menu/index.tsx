import {setAuthRouter} from "@/stores/modules/auth/action";
import {setMenuList} from "@/stores/modules/menu/action";
import {connect} from "react-redux";
import React, {useEffect, useState} from "react";
import { useLocation, useNavigate } from "react-router-dom";
import * as Icons from "@ant-design/icons";
import {RouteItem} from "@/services/system/model/menuModel";
import {getMenuList} from "@/services/system/permission/permission";
import {Menu, MenuProps, Spin} from "antd";
import {handleRouter} from "@/utils/util";
import {searchRoute} from "@/utils";

/**
 * 菜单模块
 */
const LayoutMenu = (props: any) => {
    const {setAuthRouter, setMenuList: setMenuListAction } = props;
    // 获取菜单列表并处理成 antd menu 需要的格式
    const [menuList, setMenuList] = useState<MenuItem[]>([]);
    const [loading, setLoading] = useState(false);

    // 处理后台返回菜单 key 值为 antd 菜单需要的 key 值
    const deepLoopFloat = (menuList: RouteItem[], newArr: MenuItem[] = []) => {
        menuList.forEach((item: RouteItem) => {
            // 下面判断代码解释 *** !item?.children?.length   ==>   (!item.children || item.children.length === 0)
            if (!item?.children?.length) return newArr.push(getItem(item.meta.title, item.path, addIcon(item.meta.icon!)));
            newArr.push(getItem(item.meta.title, item.path, addIcon(item.meta.icon!), deepLoopFloat(item.children)));
        });
        return newArr;
    };

    // 定义 menu 类型
    type MenuItem = Required<MenuProps>["items"][number];
    const getItem = (
        label: React.ReactNode,
        key?: React.Key | null,
        icon?: React.ReactNode,
        children?: MenuItem[],
        type?: "group"
    ): MenuItem => {
        return {
            key,
            icon,
            children,
            label,
            type
        } as MenuItem;
    };

    // 动态渲染 Icon 图标
    const customIcons: { [key: string]: any } = Icons;
    const addIcon = (name: string) => {
        return React.createElement(customIcons[name]);
    };
    const getMenuData = async () => {
        setLoading(true);
        try {
            const data = (await getMenuList()) as RouteItem[];
            if (!data) return;
            setMenuList(deepLoopFloat(data,[]));
            // 把路由菜单处理成一维数组，存储到 redux 中，做菜单权限判断
            const dynamicRouter = handleRouter(data);
            setAuthRouter(dynamicRouter);
            setMenuListAction(data);
        } finally {
            setLoading(false);
        }
    };

    useEffect(()=> {
        getMenuData();
    }, []);

    // 点击当前菜单跳转页面
    const navigate = useNavigate();
    const clickMenu: MenuProps["onClick"] = ({ key }: { key: string }) => {
        const route = searchRoute(key, props.menuList);
        // 配置外置跳转路由
        // if (route.meta.isLink) window.open(route.meta.isLink, "_blank");
        navigate(key);
    };

    return (
        <div className="menu">
            <Spin spinning={loading} tip="Loading...">
                <Menu
                    theme="light"
                    mode="inline"
                    triggerSubMenuAction="click"
                    items={menuList}
                    onClick={clickMenu}
                ></Menu>
            </Spin>
        </div>
    );
}

const mapStateToProps = (state: any) => state.menu;
const mapDispatchToProps = {setMenuList, setAuthRouter};
export default connect(mapStateToProps, mapDispatchToProps)(LayoutMenu);