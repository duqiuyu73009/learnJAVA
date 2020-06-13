package java16_0531;

/**
 * 删除操作
 */

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBCDelect {
    public static void main(String[] args) throws SQLException {
        //手动输入要删除的姓名
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的学生姓名");
        String name = scanner.next();

        //1.创建一个DataSource
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java16_0531?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("09050797");

        //2.创建connection对象，和数据库进行连接
        Connection connection = dataSource.getConnection();

        //3.拼装SQL
        String sql = "delete from student where name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);

        //4.执行SQL
        int ret = statement.executeUpdate();
        if (ret == 1){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

        //5.关闭释放资源
        statement.close();
        connection.close();
    }
}
