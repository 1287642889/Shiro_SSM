package com.wzf.service.serviceImpl;

import com.wzf.dao.RoleDao;
import com.wzf.pojo.Role;
import com.wzf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleDao roleDao;

    public Role findById(Integer id) {
        return roleDao.findById(id);
    }



    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
