package service;

import dao.UserDao;
import entity.User;

public class UserService {
    public User login(User loginUser){
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        return user;
    }

    public void register(User user){
        UserDao userDao = new UserDao();
        userDao.register(user);
    }
}
