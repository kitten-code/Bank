package bank.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String DB_URL = "jdbc:sqlserver://alewil-bank-urz-server.database.windows.net:1433;database=alewil.bank.urz;user=kittenCode@alewil-bank-urz-server;password=PiesKot12!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    private static Connection connection;
    private static Statement statement;

    public Database() {
      try {
          connection=DriverManager.getConnection(DB_URL);
          System.out.println("Polaczono z mssql");
      } catch (SQLException e) {
          System.out.println("Bez polaczenia z mssql");
          e.printStackTrace();
      }

    }

}
