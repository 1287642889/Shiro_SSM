package com.wzf.service.serviceImpl;

import com.wzf.dao.PermissionDao;
import com.wzf.pojo.Permission;
import com.wzf.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    private PermissionDao permissionDao;

    public Permission findById(Integer id) {
        return null;
    }

    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }
}
