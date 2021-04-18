package cn.awall.awalladmin.shiro.relam;

import cn.awall.awalladmin.dao.PermissionMapper;
import cn.awall.awalladmin.dao.RoleMapper;
import cn.awall.awalladmin.dao.UserMapper;
import cn.awall.awalladmin.pojo.Role;
import cn.awall.awalladmin.pojo.User;
import cn.awall.awalladmin.utils.DESUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Component
public class MRealm extends AuthorizingRealm {

    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private PermissionMapper permissionMapper;

    // 授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        // 从susbject门面拿tel
        String tel = (String) principalCollection.iterator().next();
        //数据库里查授权信息
        User user = userMapper.findUserByTel(tel);
        Assert.notNull(user,"账号不存在");
        Role role = roleMapper.findRoleByUserId(user.getUserId());
        //获取角色名
        String roleName = role.getRoleName();
        HashSet<String> set = new HashSet<>();
        set.add(roleName);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(set);
        //获取权限集合
        Set<String> ps = permissionMapper.getPermissionsByUserId(user.getUserId());
        info.setStringPermissions(ps);
        return info;
    }
    // 认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String tel = token.getUsername();
        char[] password = token.getPassword();
        String s = new String(password);
        // 安全信息
        User user = userMapper.findUserByTel(tel);
        Assert.notNull(user,"账号不存在");
        System.out.println("realm:"+user);
        ByteSource salt = ByteSource.Util.bytes(user.getSalt());
        return new SimpleAuthenticationInfo(user.getTel(),user.getPassword(),salt,getName());

    }
}
