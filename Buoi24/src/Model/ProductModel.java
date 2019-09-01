package Model;

import DBconnect.DBconnector;
import DTO.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {
    private Connection conn;

    public ProductModel() throws SQLException, ClassNotFoundException {
        DBconnector db = new DBconnector();
        this.conn = db.getConnection();
    }
    public List<Product> getProduct(){
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setCreateAt(rs.getDate("create_at"));
                list.add(p);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

    }
}
