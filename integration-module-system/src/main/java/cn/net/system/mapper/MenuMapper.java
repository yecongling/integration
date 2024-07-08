package cn.net.system.mapper;

import cn.net.system.bean.Menu;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName MenuMapper
 * @Description 菜单mapper
 * @Author ycl
 * @Date 2024/4/28 下午12:48
 * @Version 1.0
 */
@Mapper
public interface MenuMapper {

    /**
     * 获取所有菜单
     *
     * @param menu 菜单查询条件
     * @return 符合条件的菜单
     */
    List<Menu> getAllMenus(@Param("menu") JSONObject menu);

    /**
     * 查询用户菜单，是根据用户所处的角色
     *
     * @param roleId 角色ID
     * @return 用户权限
     */
    List<Menu> queryByUser(@Param("roleId") String roleId);

    /**
     * 查询目录 - 一级菜单
     *
     * @param roleId 角色ID
     * @return 一级菜单
     */
    List<Menu> getDirectory(@Param("roleId") String roleId);

    /**
     * 添加菜单
     *
     * @param menu 菜单对象
     * @return 受影响的行数
     */
    int addMenu(Menu menu);

    /**
     * 更新菜单
     *
     * @param menu 菜单对象数据
     * @return -
     */
    int updateMenu(Map<String, Object> menu);

    /**
     * 删除菜单
     *
     * @param id 菜单ID
     * @return -
     */
    int deleteMenu(String id);
}
