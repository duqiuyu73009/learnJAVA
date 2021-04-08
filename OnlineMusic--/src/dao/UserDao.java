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
    public static User login(User loginUser){
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


    /*
    注册
     */
    public void register(User user){
        //1.获取带数据库连接
        Connection connection = DBUtils.getConnection();
        //2.拼装sql语句
        String sql = "insert into user values (null,?,?,?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getGender());
            statement.setString(5, user.getEmail());
            //3.执行sql语句
            statement.executeUpdate();
            if(statement.executeUpdate() != 1){
                //插入失败
                System.out.println("插入新用户失败！");
                return;
            }
            System.out.println("插入新用户成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //4.释放数据库连接
            DBUtils.getClose(connection,statement,null);
        }
    }

    public static void main(String[] args) {
//        User user = new User();
//        user.setUsername("dqy");
//        user.setPassword("123");
//        user.setAge(34);
//        user.setGender("女");
//        user.setEmail("9875435673@qq.com");
//        UserDao.add(user);
    }
}
