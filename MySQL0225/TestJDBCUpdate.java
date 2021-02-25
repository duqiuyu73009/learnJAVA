package MySQL0225;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBCUpdate {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要修改的id");
        int id = scanner.nextInt();
        System.out.println("请输入需要修改的name");
        String name = scanner.next();

        //1.创建DataSource 对象
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_0224?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("09050797");

        //2.连接数据库
        Connection connection = dataSource.getConnection();

        //3.写sql语句
        String sql = "Update student set name = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);
        statement.setInt(2,id);

        //4.执行sql语句
        int ret = statement.executeUpdate();
        if (ret ==1){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }

        //5.关闭资源
        statement.close();
        connection.close();
    }
}
