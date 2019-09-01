package Model;

import DBconnect.DBconnector;
import DTO.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberModel {
    private Connection conn;

    public MemberModel() throws SQLException, ClassNotFoundException {
        DBconnector db = new DBconnector();
        this.conn = db.getConnection();
    }
    public int addMember(Member member){
        String sql="INSERT INTO member (name,email,password) VALUES (?,?,?)";
        int check = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,member.getName());
            ps.setString(2,member.getEmail());
            ps.setString(3,member.getPassword());
            check = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return check;
    }
    public boolean checkRegister(String email){
        String sql ="SELECT * FROM member WHERE email=?";
        Member member = null;
        boolean check = false;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                check=true;
            }else{
                check=false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
       return check;
    }
    public Member checkLogin(String email, String password){
        String sql = "SELECT * FROM member WHERE email=? && password=?";
        Member member = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
           while (rs.next()){
               member = new Member();
               member.setId(rs.getInt("id"));
               member.setName(rs.getString("name"));
               member.setEmail(rs.getString("email"));
           }
        }catch (Exception e){
            e.printStackTrace();
        }
        return member;
    }

}
