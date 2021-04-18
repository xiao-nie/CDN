package cn.awall.awalladmin;

import cn.awall.awalladmin.dao.RoleMapper;
import cn.awall.awalladmin.pojo.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RoleMapperTest {

    @Resource
    private RoleMapper roleMapper;

    /**
     * 查询所有
     */
    @Test
    public void testfindAll(){

        List<Role> roles = roleMapper.queryRoles();
        for (Role role : roles) {
            System.out.println(role);
        }
    }

    /**
     * 添加
     */
    @Test
    public void testInsert(){
        Role role = new Role(null, "user", "普通用户");
        roleMapper.addRole(role);
        System.out.println(role);
    }

    /**
     * 删除
     */
    @Test
    public void del(){
        int i = roleMapper.delUserById(1L);
        System.out.println(i);
    }

    /**
     * 修改
     */
    @Test
    public void update(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("roleId",2L);
        map.put("roleName","test");
        map.put("roleDesc","测试了修改");
        int i = roleMapper.updateRoleByMap(map);
        System.out.println(i);
    }
}
