package com.wzf.service;

import com.wzf.pojo.Users;
import java.util.Set;

public interface UsersService {
    Users findByUserName(String username);
    Set<String> findRoles(String username);
    Set<String> findPermissions(String username);
}
