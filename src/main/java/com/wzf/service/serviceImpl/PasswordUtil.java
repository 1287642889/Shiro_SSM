package com.wzf.service.serviceImpl;

import com.wzf.Salt.Salt;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 密码加密
 */
public class PasswordUtil {

    public static String encodePwd(String pwd){
        return new Md5Hash(pwd, Salt.salt,2).toString();
    }
}
