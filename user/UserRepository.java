package user;

import java.sql.*;

public class UserRepository {
    public void findusers() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/erichgammadb";
        String userName = "erichgamma";
        String password = "erichgammadb";

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from board");

        resultSet.next();
        String name = resultSet.getString("name");
        System.out.println(name);

        resultSet.close();
        statement.close();
        connection.close();
    }
}