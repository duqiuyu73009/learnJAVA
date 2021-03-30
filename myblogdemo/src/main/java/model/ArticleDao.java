package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {
    //1.新增文章（发布博客）
    public void add(Article article){
        //1.获取数据库连接
        Connection connection = DBUtil.getConnection();
        //2.构造sql
        String sql = "insert into article value (null,?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,article.getTitle());
            statement.setString(2,article.getContent());
            statement.setInt(3,article.getUserId());
            //3.执行sql
            int ret = statement.executeUpdate();
            if (ret != 1){
                System.out.println("插入文章操作失败！");
                return;
            }
            System.out.println("插入文章操作成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //4.释放连接
            DBUtil.close(connection,statement,null);
        }
    }


    //2.查看文章（把所有的文章信息都查出来）
    public List<Article> selectAll(){
        List<Article> articles = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        String sql = "select article,title,userId from article";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Article article = new Article();
                article.setArticleId(resultSet.getInt("articleId"));
                article.setTitle(resultSet.getString("title"));
                article.setUserId(resultSet.getInt("userId"));
                articles.add(article);
            }
            return articles;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    //3.查看指定的文章详情
    public Article selectById(int articleId){
        Connection connection = DBUtil.getConnection();
        String sql = "select * from where articleId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,articleId);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                Article article = new Article();
                article.setArticleId(resultSet.getInt("articleId"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setUserId(resultSet.getInt("userId"));
                return article;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    //4.删除指定文章
    public void delete(int articleId){
        Connection connection = DBUtil.getConnection();
        String sql = "delete from article where articleId = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,articleId);
            int ret = statement.executeUpdate();
            if (ret != 1){
                System.out.println("删除文章失败！");
                return;
            }
            System.out.println("删除文章成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }
}

