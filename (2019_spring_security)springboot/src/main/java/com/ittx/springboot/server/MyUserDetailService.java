package com.ittx.springboot.server;

import org.apache.log4j.Logger;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class MyUserDetailService implements UserDetailsService {
    private Logger logger = Logger.getLogger(MyUserDetailService.class);
    @Override
    public UserDetails loadUserByUsername(String usernaem) throws UsernameNotFoundException {
        logger.info("用户的用户名:"+usernaem);

        User user = new User(usernaem,"123456",AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return user;
    }
}
