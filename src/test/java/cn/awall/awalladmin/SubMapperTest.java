package cn.awall.awalladmin;

import cn.awall.awalladmin.dao.SubMapper;
import cn.awall.awalladmin.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class SubMapperTest {

    @Resource
    SubMapper subMapper;
    @Test
    public void test1(){

        List<User> users = subMapper.queryFansById(18L);

        for (User user : users) {
            System.out.println("user = " + user);
        }

    }
}
