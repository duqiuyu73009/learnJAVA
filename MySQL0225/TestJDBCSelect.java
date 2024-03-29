package MySQL0225;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBCSelect {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_0224?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("09050797");

        //2.和数据库建立连接
        Connection connection = dataSource.getConnection();

        //写SQL
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);

        //执行sql
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int classId = resultSet.getInt("classId");
            System.out.println("id:"+id + "  name:"+name + "  classId:"+classId);
        }

        //关闭
        resultSet.close();
        statement.close();
        connection.close();
    }
}
