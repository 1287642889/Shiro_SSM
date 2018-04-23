package com.wzf.service.serviceImpl;

import com.wzf.dao.*;
import com.wzf.pojo.*;
import com.wzf.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private UsersRoleDao usersRoleDao;
    @Autowired
    private RolePermissionDao rolePermissionDao;

    //根据用户名查找用户
    public Users findByUserName(String username){
        List<Users> list = usersDao.findByUserName(username);
        if(list.size()<1){
            return null;
        }else{
            return list.get(0);
        }
    }

    //根据用户名查找用户角色
    public Set<String> findRoles(String username){
        Set<String> roleNameSet = new HashSet<>();
        Integer userId = findByUserName(username).getId();
        List<UserRole> usersRoleList = usersRoleDao.findByUserId(userId);
        for(int i = 0; i < usersRoleList.size(); i++){
           Role role = roleDao.findById(usersRoleList.get(i).getRoleId());
            roleNameSet.add(role.getRoleName());
        }
        return roleNameSet;
    }

    //根据用户名查找用户权限
    public Set<String> findPermissions(String username){
        Set<String> permissionNameSet = new HashSet<>();
        Integer userId = findByUserName(username).getId();
        List<Integer> roleIdList = new ArrayList<>();
        List<UserRole> usersRoleList = usersRoleDao.findByUserId(userId);
        for(int i = 0; i < usersRoleList.size(); i++){
            Integer roleId = roleDao.findById(usersRoleList.get(i).getRoleId()).getId();
            roleIdList.add(roleId);
        }
        List<RolePermission> rolePermissionList = rolePermissionDao.findByRoleIdIn(roleIdList);
        for(int i = 0;i<rolePermissionList.size();i++){
            Permission permission = permissionDao.findById(rolePermissionList.get(i).getPermissionId());
            permissionNameSet.add(permission.getPermissionName());
        }
        return permissionNameSet;
    }




    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    public void setUsersRoleDao(UsersRoleDao usersRoleDao) {
        this.usersRoleDao = usersRoleDao;
    }

    public void setRolePermissionDao(RolePermissionDao rolePermissionDao) {
        this.rolePermissionDao = rolePermissionDao;
    }
}
