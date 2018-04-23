package com.wzf.service;


import com.wzf.pojo.UserRole;
import java.util.List;

public interface UsersRoleService {
    List<UserRole> findByUserId(Integer userId);
}
