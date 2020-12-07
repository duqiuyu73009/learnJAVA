package dao;


import entity.User;
import util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 有关用户相关的数据库操作
 */
public class UserDao {

    /*
     登录
       */
    public User login(User loginUser){
        User user = null;
        Connection connection = null;//获取链接
        PreparedStatement ps = null;//预编译sql语句
        ResultSet rs = null;//从数据库拿到的结果集的集合

        try {
            String sql = "select * from user where username = ? and password = ? ";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);//预编译
            ps.setString(1,loginUser.getUsername());
            ps.setString(2,loginUser.getPassword());

            //执行sql语句
            rs = ps.executeQuery();//查询
            if (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setGender(rs.getString("gender"));
                user.setEmail(rs.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection, ps, rs);
        }
        return user;
    }

    public static void main(String[] args) {
//        User user = new User();
//        user.setUsername("bit");
//        user.setPassword("123");
//        User loginUser = login(user);
//        System.out.println(loginUser);
    }
}
