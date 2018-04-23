package com.wzf.service.serviceImpl;

import com.wzf.dao.UsersRoleDao;
import com.wzf.pojo.UserRole;
import com.wzf.service.UsersRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersRoleServiceImpl implements UsersRoleService{
    @Autowired
    private UsersRoleDao usersRoleDao;

    public List<UserRole> findByUserId(Integer userId) {
        return usersRoleDao.findByUserId(userId);
    }



    public void setUsersRoleDao(UsersRoleDao usersRoleDao) {
        this.usersRoleDao = usersRoleDao;
    }
}
