package MySQL0225;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBCDelete {
    public static void main(String[] args) throws SQLException {
        System.out.println("请输入需要删除的classId");
        Scanner scanner = new Scanner(System.in);
        int classId = scanner.nextInt();

        //1.创建DataSource 对象
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_0224?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("09050797");

        //2.连接数据库
        Connection connection = dataSource.getConnection();

        //3.写sql语句
        String sql = "delete from student where classId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,classId);

        //4.执行sql语句
        int ret = statement.executeUpdate();
        if (ret == 1){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

        //5.关闭资源
        statement.close();
        connection.close();
    }
}
