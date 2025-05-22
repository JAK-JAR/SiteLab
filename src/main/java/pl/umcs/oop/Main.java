package pl.umcs.oop;

import pl.umcs.oop.auth.AccountManager;
import pl.umcs.oop.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        db.connect("test.db");
        AccountManager am = new AccountManager(db);
        am.register("user2", "test");
        System.out.println(am.authenticate("user2", "test"));
        System.out.println(am.getAccount("user2"));
        System.out.println(am.getAccount(2));
    }
}