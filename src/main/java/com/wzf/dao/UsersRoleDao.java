package com.wzf.dao;

import com.wzf.pojo.UserRole;
import java.util.List;

public interface UsersRoleDao {
    List<UserRole> findByUserId(Integer userId);
}
