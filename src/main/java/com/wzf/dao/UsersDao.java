package com.wzf.dao;

import com.wzf.pojo.Users;
import java.util.List;

public interface UsersDao {
    List<Users> findByUserName(String username);

}
