package MySQL0225;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBAAdd {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要插入的id");
        int id = scanner.nextInt();
        System.out.println("请输入需要插入的name");
        String name = scanner.next();
        System.out.println("请输入需要插入的classId");
        int classId = scanner.nextInt();

        //1.创建DataSource对象
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_0224?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("09050797");

        //2.和数据库建立连接
        Connection connection = dataSource.getConnection();

        //3.编写SQL语句
        String sql = "insert into student values (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.setString(2,name);
        statement.setInt(3,classId);
        System.out.println("statement:"+statement);

        //4.执行SQL语句
        int ret = statement.executeUpdate();
        System.out.println("ret: "+ret);

        //5.关闭资源
        statement.close();
        connection.close();
    }

}
