package com.wzf.service;

import com.wzf.pojo.RolePermission;

import java.util.List;

public interface RolePermissionService {
    List<RolePermission> findByRoleIdIn(List<Integer> roleIdList);
}
