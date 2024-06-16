package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	private String jdbcURL = "jdbc:postgresql://localhost:5432/rms"; // データベースのURLを適宜変更する
    private String jdbcUsername = "testpg";
    private String jdbcPassword = "testpg";
    
    public LoginDAO() {
    }
    
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver"); // PostgreSQLの場合、適切なドライバーを使用する
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public String getPasswordByLoginId(String loginId) {
        String password = null;
        String sql = "SELECT password FROM public.\"user\" WHERE \"userId\" = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, loginId);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                password = rs.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }
}
