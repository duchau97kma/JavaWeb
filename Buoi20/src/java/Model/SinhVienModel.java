/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bean.SinhVien;
import Connector.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Winter
 */
public class SinhVienModel {
    private Connection conn;

    public SinhVienModel() throws ClassNotFoundException, SQLException {
        DBconnect db = new DBconnect();
        this.conn = db.getConnection();
    }
    
    public int addSv(SinhVien sv) throws SQLException{
        String sql = "INSERT INTO sv (hoten,khoa,lop) VALUES(?,?,?)";
        PreparedStatement ps = conn.prepareCall(sql);
        ps.setString(1, sv.getHoten());
        ps.setString(2, sv.getKhoa());
        ps.setString(3, sv.getLop());
        return ps.executeUpdate();
    }
    public int updateSv(SinhVien sv) throws SQLException{
        String sql ="UPDATE sv SET hoten=?,khoa=?,lop=? WHERE id=?";
        PreparedStatement ps = conn.prepareCall(sql);
        ps.setString(1, sv.getHoten());
        ps.setString(2, sv.getKhoa());
        ps.setString(3, sv.getLop());
        ps.setInt(4, sv.getId());
        return ps.executeUpdate();
    }
    
    public void deleteSv(int id) throws SQLException{
        String sql = "DELETE FROM sv WHERE id=?";
        PreparedStatement ps = conn.prepareCall(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
    public List<SinhVien> showSV() throws SQLException {
    List<SinhVien> list = new ArrayList<>();
    String sql = "SELECT * FROM sv";
    PreparedStatement ps = conn.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            SinhVien sv = new SinhVien();
            sv.setId(rs.getInt("id"));
            sv.setHoten(rs.getString("hoten"));
            sv.setKhoa(rs.getString("khoa"));
            sv.setLop(rs.getString("lop"));
            list.add(sv);
        }
        
    return list;
}
    public SinhVien getSvById(int id) throws SQLException{
        SinhVien sv = null;
        String sql ="SELECT * FROM sv WHERE id=?";
        PreparedStatement ps = conn.prepareCall(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            String hoten = rs.getString("hoten");
            String khoa = rs.getString("khoa");
            String lop = rs.getString("lop");
            int idsv = rs.getInt("id");
            sv = new SinhVien(id, hoten, khoa, lop);
        }
        return sv;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        SinhVienModel model = new SinhVienModel();
        for (SinhVien sv : model.showSV()) {
            System.out.println(sv);
        }
    }
}
