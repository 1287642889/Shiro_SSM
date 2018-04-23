package com.wzf.service.serviceImpl;


import com.wzf.dao.RolePermissionDao;
import com.wzf.pojo.RolePermission;
import com.wzf.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService{

    @Autowired
    private RolePermissionDao rolePermissionDao;

    public List<RolePermission> findByRoleIdIn(List<Integer> roleIdList) {
        return rolePermissionDao.findByRoleIdIn(roleIdList);
    }




    public void setRolePermissionDao(RolePermissionDao rolePermissionDao) {
        this.rolePermissionDao = rolePermissionDao;
    }
}
