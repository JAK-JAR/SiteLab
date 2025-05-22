package pl.umcs.oop.auth;

import pl.umcs.oop.database.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountManager {
    private DatabaseConnection db;

    public AccountManager(DatabaseConnection db) {
        this.db = db;
        initTable();
    }

    private void initTable() {
        try(Statement stmt = db.getConnection().createStatement()) {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS users (" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, username TEXT NOT NULL UNIQUE, password TEXT NOT NULL)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void register(String userName, String password) throws SQLException {
        PreparedStatement stmt = db.getConnection().prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
        stmt.setString(1, userName);
        stmt.setString(2, password);
        stmt.executeUpdate();
    }
//
//    public boolean authenticate(String userName, String password) {
//
//    }
//
//    public Account getAccount(String userName) {
//
//    }
//
//    public Account getAccount(int id) {
//
//    }
}