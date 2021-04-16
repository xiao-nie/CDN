package cn.awall.awalladmin;

import cn.awall.awalladmin.dao.PermissionMapper;
import cn.awall.awalladmin.dao.RoleMapper;
import cn.awall.awalladmin.pojo.Permission;
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
public class PermissionMapperTest {

    @Resource
    private PermissionMapper permissionMapper;

    /**
     * 查询所有
     */
    @Test
    public void testfindAll(){

        List<Permission> permissions = permissionMapper.queryPermissions();
        for (Permission permission : permissions) {
            System.out.println(permission);
        }
    }

    /**
     * 添加
     */
    @Test
    public void testInsert(){
        Permission permission = new Permission(null, "user", "普通用户");
        permissionMapper.addPermission(permission);
        System.out.println(permission);
    }

    /**
     * 删除
     */
    @Test
    public void del(){
        int i = permissionMapper.delPermissionById(1L);
        System.out.println(i);
    }

    /**
     * 修改
     */
    @Test
    public void update(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("permissionId",2L);
        map.put("perCode","test");
        map.put("perDesc","测试了修改");
        int i = permissionMapper.updatePermissionByMap(map);
        System.out.println(i);
    }
}
