package cn.soft.modules.system.user.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @ClassName DefaultUserDetailsService
 * @Description 用户登录认证逻辑
 * @Author ycl
 * @Date 2022/12/5 11:53
 * @Version 1.0
 */
@Component
public class DefaultUserDetailsService implements UserDetailsService {
    /**
     * @param username 用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
