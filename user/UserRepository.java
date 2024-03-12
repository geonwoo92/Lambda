package com.erich.api.user;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.erich.api.crawler.CrawlerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {



    private static UserRepository instance;

    private PreparedStatement pstmt;
    private ResultSet rs;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection connection;

    UserRepository() throws SQLException {

        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/erichgammadb",
                "erichgamma",
                "erichgammadb");

        pstmt=null;
        rs = null;


    }

    public static UserRepository getInstance() {
        return instance;
    }

    public String test() {
        return "UserRepository 연결";
    }

    public List<?> findUsers() throws SQLException {


        String sql = "select * from articles";
        pstmt = connection.prepareStatement(sql);
        rs = pstmt.executeQuery();
        System.out.println("ResultSet Size");

        if (rs.next()) {
            do {
                System.out.printf("ID: %d\t Title: %s\t Content: %s\t Writer: %s",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                System.out.println();
            } while (rs.next());

        } else {
            System.out.println("데이터가 없습니다.");
        }

        return null;
    }

    public String createTable() throws SQLException {

        String sql = "CREATE TABLE Users (id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "                    username VARCHAR(20) NOT NULL,\n" +
                "                    password VARCHAR(20) NOT NULL,\n" +
                "                    name VARCHAR(20),\n" +
                "                    phone VARCHAR(20),\n" +
                "                    addressID VARCHAR(20),\n" +
                "                    job VARCHAR(20),\n" +
                "                    height VARCHAR(20),\n" +
                "                    weight VARCHAR(20))";

        String msg = "";

        PreparedStatement pstmt = connection.prepareStatement(sql);
        int ac = pstmt.executeUpdate();
        System.out.println("쿼리의 반환값은 :" + ac);
        if (ac == 0) {
            msg = "성공";
        } else {
            msg = "실패";
        }

        connection.close();

        return (ac == 0) ? "성공" : "실패" ;
    }

    public String deleteTable() throws SQLException {

        String sql = "DROP TABLE Users";

        String msg = "";

        PreparedStatement pstmt = connection.prepareStatement(sql);
        int ac = pstmt.executeUpdate();
        System.out.println("쿼리의 반환값은 :" + ac);

        if (ac == 0) {
            msg = "성공";
        } else {
            msg = "실패";
        }

        return (ac == 0) ? "성공" : "실패";
    }





}

