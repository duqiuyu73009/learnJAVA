package model;

//管理数据库连接
//1.建立连接
//2.断开连接
//JDBC使用DataSourcr来管理连接
//DBUtil相当于是对DataSource再稍微包装一层
//因为 DataSource 应该是每个应用程序只应该有一个实例
//DBUtil本质上就是实现了一个单例模式，管理了一个唯一的DataSource实例

//单例模式的实现，有两种风格
//1.饿汉模式
//2.懒汉模式（在这里实现的）_______主要问题：线程不安全

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    private static volatile DataSource dataSource = null;
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/blogdome?characterEncoding=utf-8&useSSL=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "09050797";

    public static DataSource getDataSource(){
        if (dataSource == null) {
            synchronized (DBUtil.class) {
                if (dataSource == null){
                    dataSource = new MysqlDataSource();
                    //需要给DataSource设置一些属性
                    ((MysqlDataSource)dataSource).setURL(URL);
                    ((MysqlDataSource)dataSource).setUser(USERNAME);
                    ((MysqlDataSource)dataSource).setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }

    //通过这个方法来获取连接
    public static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过这个方法断开连接
    public static void close(Connection connection, PreparedStatement statement,
                             ResultSet resultSet){
        try {
            if (resultSet != null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
