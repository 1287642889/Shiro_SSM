package com.wzf.dao;

import com.wzf.pojo.RolePermission;

import java.util.List;

public interface RolePermissionDao {
    List<RolePermission> findByRoleIdIn(List<Integer> roleIdList);
}
