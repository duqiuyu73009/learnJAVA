import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//链接数据库
public class TestMySQL {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/java16_0531?characterEncoding=utf-8&useSSL=true";
        String username = "root";
        String password = "09050797";
        //借助DataSource来管理信息
        //1.创建DataSource实例，并设置数据库相关参数
        DataSource dataSource = new MysqlDataSource();
        //向下转型
        ((MysqlDataSource)dataSource).setURL(url);
        ((MysqlDataSource)dataSource).setUser(username);
        ((MysqlDataSource)dataSource).setPassword(password);
        //2.和数据库建立连接
        Connection connection = dataSource.getConnection();
        //3.访问数据库，需要先拼装一个sql语句
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);
        //4.执行sql
        ResultSet resultSet = statement.executeQuery();
        //5.遍历结果集
        //每次调用next方法就能获取到一条记录
        //进一步使用getXXX方法，根据列明获取到列的数据
        while (resultSet.next()){
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getInt("classId"));
        }
        //6.关闭连接，释放资源
        //关闭顺序和创建顺序正好相反
        resultSet.close();
        statement.close();
        connection.close();
    }
}
