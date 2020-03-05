package com.javaboy.securitydb.mapper;

import com.javaboy.securitydb.bean.Role;
import com.javaboy.securitydb.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User loadUserByUsername(String username);

    List<Role> getUserRolesById(Integer id);
}
