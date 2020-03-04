package com.javaboy.securitydb.service;

import com.javaboy.securitydb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;


import com.javaboy.securitydb.bean.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userMapper.loadUserByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("用户名不存在！");
        }
        user.setRoles(userMapper.getUserRolesById());
        return user;

    }
}
