package com.wzf.Realm;

import com.wzf.pojo.Users;
import com.wzf.service.UsersService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UsersService usersService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
//        Users user = userService.findByUserName(username);
//        user.setLocked(true);   //登录成功后锁定用户
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(usersService.findRoles(username));
        authorizationInfo.setStringPermissions(usersService.findPermissions(username));

        for(int i = 0; i<authorizationInfo.getRoles().size();i++){
            System.out.println(authorizationInfo.getRoles());
        }
        for(int i = 0; i<authorizationInfo.getStringPermissions().size();i++){
            System.out.println(authorizationInfo.getStringPermissions());
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();
        Users user = usersService.findByUserName(username);
        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }
//        if(Boolean.TRUE.equals(user.getLocked())) {
//            throw new LockedAccountException(); //帐号锁定
//        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUserName(), //用户名
                user.getPassword(), //密码
                getName()  //realm name
        );
        return authenticationInfo;
    }

    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }
}
