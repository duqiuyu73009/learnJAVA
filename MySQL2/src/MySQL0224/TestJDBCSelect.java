package MySQL0224;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//查找操作
public class TestJDBCSelect {
    public static void main(String[] args) throws SQLException {
        //1. 创建DataSource对象
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_0224?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("09050797");

        //2.创建Connection 对象
        Connection connection = dataSource.getConnection();

        //3.借助PrepareStatement拼装SQL语句
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);

        //4.执行SQL语句
        ResultSet resultSet = statement.executeQuery();

        //5.遍历结果集
        //  建立过程和使用迭代器遍历集合类有点像
        while (resultSet.next()){
            //resultSet 的光标指向了当前行，就可以把当前列中的数据全部获取到
            //当前表中的每一行包含三个列，id、name、classId，可以根据列名来获取对应列的数据
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int classId = resultSet.getInt("classId");
            //此处参数中的列名必须和数据库中的列名完全一致，顺序无所谓
            System.out.println("id:"+id+"   name:"+name+"   classId:"+classId);
        }

        //6.关闭释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
