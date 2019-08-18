/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DBconnector.DBconnect;
import DTO.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Winter
 */
public class BookModel {

    private Connection conn;

    public BookModel() {
        DBconnect db = new DBconnect();
        this.conn = db.getConnection();
    }

    public int addBook(Book book) {
        int check = 0;
        String sql = "INSERT INTO book (title,author,price,quantity) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setDouble(3, book.getPrice());
            ps.setInt(4, book.getQuantity());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public int updateBook(Book book) {
        int check = 0;
        String sql = "UPDATE book SET title=?, author=?,price=?,quantity=? WHERE id=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setDouble(3, book.getPrice());
            ps.setInt(4, book.getQuantity());
            ps.setInt(5, book.getId());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public int deleteBook(int id) {
        int check = 0;
        String sql = "DELETE FROM book WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public Book getBookById(int id) {
        Book book = null;
        String sql = "SELECT * FROM book WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                book = new Book(id, title, author, price, quantity);
            }
        } catch (Exception e) {
        }
        return book;
    }

    public List<Book> getAll() {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM book";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getDouble("price"));
                book.setQuantity(rs.getInt("quantity"));
                list.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        BookModel model = new BookModel();
        for (Book book : model.getAll()) {
            System.out.println(book.toString());
        }
    }

}
