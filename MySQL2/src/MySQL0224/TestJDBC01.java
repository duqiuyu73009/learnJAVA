package MySQL0224;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//增删改操作
public class TestJDBC01 {
    public static void main(String[] args) throws SQLException {
        //1.创建DataSource对象(dataSource生命周期是跟随整个程序)
        DataSource dataSource = new MysqlDataSource();
        //  接下来需要针对 DataSource进行一些配置，保证后面能够顺利的访问数据库
        //  主要配置三个信息：URL  User  Password
        //  以上过程需要进行向下转型
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_0224?characterEncoding=utf-8&useSSL=true");
        //  此处的127.0.0.1就表示本机，只要Mysql装在本机都可以使用这个ip
        //  3306是端口号
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("09050797");

        //2.和数据库建立连接
        //  建立连接的意义是为了验证当前网络通信是否正常
        //  如果不正常就会抛出 SQLException异常
        //  connect生命周期是较短的，每个请求创建一个新的connect
        Connection connection = dataSource.getConnection();

        //3.拼装SQL语句，用到 PrepareStatement 对象
        //  当前示例中插入的数据内容是确定的。也可以动态拼接进去
//        String sql = "insert into student values(1, '曹操', 10)";
//        PreparedStatement statement = connection.prepareStatement(sql);
        //  动态拼装是这样的
        //  ？是一个占位符，可以把具体的变量的值替换到 ？位置
        int id = 1;
        String name = "曹操";
        int classId = 10;
        String sql = "insert into student values(?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        //此处的1，2，3相当于 ？ 的下标（从1开始算）
        statement.setInt(1,id);
        statement.setString(2,name);
        statement.setInt(3,classId);
        System.out.println("statement："+statement);

        //4.拼装完之后，开始执行SQL
        //   insert  delete  update  都使用executeUpdate()方法
        //   select 使用 executeQuery() 来执行
        //返回值表示此次操作修改了多少行
        int ret = statement.executeUpdate();
        System.out.println("ret:" + ret);

        //5.执行完毕之后需要释放相关资源
        //  后创建的先释放
        statement.close();
        connection.close();
    }
}
