package cn.awall.awalladmin;

import cn.awall.awalladmin.dao.RpMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RpMapperTest {

    @Resource
    private RpMapper rpMapper;
    /**
     * 测试添加
     */
    @Test
    public void testAdd(){
        int i = rpMapper.addRp(1L,2L);
        System.out.println(i);
    }

    /**
     * 测试删除 通过id
     */
    @Test
    public void testDel1(){
        int i = rpMapper.delRpById(1L);
        System.out.println(i);
    }

    /**
     * 测试通过roleId删除
     */
    @Test
    public void  testDel2(){
        int i = rpMapper.delRpByPermissionId(1L);
        System.out.println(i);
    }

    /**  c
     * 测试通过userId删除
     */
    @Test
    public void testDel3(){
        int i = rpMapper.delRpByRoleId(2L);
        System.out.println(i);
    }
}
