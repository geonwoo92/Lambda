package com.erich.api.menu;

import com.erich.api.enums.Messenger;
import lombok.Getter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    @Getter
    private final static MenuRepository instance;

    static {
        try {
            instance = new MenuRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private MenuRepository() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/erichgammadb",
                "erichgamma",
                "erichgammadb");
        pstmt = null;
        rs = null;
    }

    public Messenger makeTable() {
        String sql = "CREATE TABLE IF NOT EXISTS menus (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "category VARCHAR(10) NOT NULL," +
                "item VARCHAR(20) NOT NULL)";
        try {
            pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return Messenger.SQL_ERROR;
        }
    }

    public Messenger removeTable() {
        String sql = "DROP TABLE IF EXISTS menus";
        try {
            pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return Messenger.SQL_ERROR;
        }
    }

    public Messenger insertMenu(Menu menu) {
        String sql = "INSERT INTO menus(category, item) VALUES(?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, menu.getCategory());
            pstmt.setString(2, menu.getItem());
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred :" + menu.getCategory() + " " + menu.getItem());
            return Messenger.SQL_ERROR;
        }
    }

    public List<?> getMenusByCategory(String category){
        String sql = "SELECT m.item FROM menus m WHERE category = ?";
        List<Menu> menus = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, category);
            rs = pstmt.executeQuery();
            while(rs.next())    menus.add(Menu.builder().item(rs.getString(1)).build());
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return menus;
        }
        return menus;
    }


//    public List<Menu> allList() throws SQLException {
//
//        String sql = "";
//        pstmt = conn.prepareStatement(sql);
//        // 리턴타입이 Messenger 인 경우
//        rs =pstmt.executeQuery(sql);
//        List<Menu> ls = new ArrayList<>();
//        if(rs.next()){
//            do{Menu m =Menu.builder()
//                    .item(rs.getString("item"))
//                    .category(rs.getString("category"))
//
//                    .build();
//                ls.add(m);
//
//            }while (rs.next());
//        }else {
//            System.out.println("No data");
//        }
//        System.out.println("쿼리 성공여부: "+rs);
//        //리턴타입이 리스트인 경주
//        return ls;
//    }


    public Messenger returnMessenger() throws SQLException {
        String sql ="";
        pstmt = conn.prepareStatement(sql);
        Messenger m =null;
        Messenger rs = (pstmt.executeUpdate()==0)? Messenger.SUCCESS:Messenger.FAIL;
        return m;

    }

    public List<Menu> returnAllMenus(String bu) throws SQLException {
        String sql = "select * from menus where category = ?";
        pstmt =conn.prepareStatement(sql);
        pstmt.setString(1, bu);
        rs = pstmt.executeQuery();

        List<Menu> ls = new ArrayList<>();
        if(rs.next()){
            do{
                Menu m = Menu.builder()
                        .item(rs.getString("item"))
                        .category(rs.getString("category"))
                        .build();
                ls.add(m);
            }while (rs.next());
        }else {  System.out.println("No data");}
        return ls;
    }
}
