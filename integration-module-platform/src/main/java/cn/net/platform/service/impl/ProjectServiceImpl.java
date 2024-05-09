package cn.net.platform.service.impl;

import cn.net.platform.mapper.ProjectMapper;
import cn.net.platform.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName ProjectServiceImpl
 * @Description 项目管理service
 * @Author ycl
 * @Date 2024/4/28 下午12:54
 * @Version 1.0
 */
@Service
public class ProjectServiceImpl implements IProjectService {
    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectServiceImpl(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }
}
