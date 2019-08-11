/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bean.Author;
import Bean.News;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Winter
 */
public class NewsModel {
    private Connection conn;

    public NewsModel() {
        DBconnector db = new DBconnector();
        this.conn = db.getConnection();
    }
    public int countNews() throws Exception, ClassNotFoundException {
        PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) FROM news");
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
    
    public List<News> getNews(int limit, int offset) throws Exception, ClassNotFoundException {
        PreparedStatement pstmt = conn.prepareStatement("select news.*, author.name, author.email from news join author on news.author_id = author.id LIMIT ? OFFSET ?");
        pstmt.setInt(1, limit);
        pstmt.setInt(2, offset);
        ResultSet rs = pstmt.executeQuery();
        List<News> list = new ArrayList<News>();
        while (rs.next()) {
            News news = new News();
            news.setId(rs.getInt("id"));
            news.setTitle(rs.getString("title"));
            news.setContent(rs.getString("content"));
            news.setSummary(rs.getString("summary"));
            news.setAuthor(new Author(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
            list.add(news);
        }
        return list;
    }
    public List<News> findNews(String title) throws Exception {
       PreparedStatement pstmt = conn.prepareStatement("select news.*, author.name, author.email from news join author on news.author_id = author.id where news.title like ?");
       pstmt.setString(1, "%"+title+"%");
       ResultSet rs = pstmt.executeQuery();
       List<News> list = new ArrayList<>();
       while (rs.next()) {
            News news = new News();
            news.setId(rs.getInt("id"));
            news.setTitle(rs.getString("title"));
            news.setContent(rs.getString("content"));
            news.setSummary(rs.getString("summary"));
            news.setAuthor(new Author(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
            list.add(news);
        }
        return list;
    }
    
    public static void main(String[] args) throws Exception {
        NewsModel model = new NewsModel();
        for (News news : model.findNews("W")) {
            System.out.println(news.toString());
        }
    }
  
    
}
