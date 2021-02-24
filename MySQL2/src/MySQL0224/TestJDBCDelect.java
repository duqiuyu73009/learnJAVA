package MySQL0224;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBCDelect {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的学生姓名");
        String name = scanner.next();
        //1.创建DataSource对象(dataSource生命周期是跟随整个程序)
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_0224?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("09050797");

        //2.和数据库建立连接
        Connection connection = dataSource.getConnection();

        //3.拼装SQL语句，用到 PrepareStatement 对象
        String sql = "delete from student where name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);

        //4.拼装完之后，开始执行SQL
        int ret = statement.executeUpdate();
        if (ret == 1){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

        //5.执行完毕之后需要释放相关资源
        statement.close();
        connection.close();
    }
}
