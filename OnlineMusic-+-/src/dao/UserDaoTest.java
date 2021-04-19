package dao;

import entity.User;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * UserDao 单元测试
 */
public class UserDaoTest {

    @Ignore
    @Test
    public void login() {

    }

    @Test
    public void register() {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername("hh");
        user.setPassword("123");
        user.setAge(23);
        user.setGender("女");
        user.setEmail("123345623@qq.com");
        userDao.register(user);
    }
}