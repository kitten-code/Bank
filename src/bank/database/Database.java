package bank.database;

import bank.models.BankAccount;
import bank.models.Client;
import bank.models.History;

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
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("Polaczono z mssql");
        } catch (SQLException e) {
            System.out.println("Bez polaczenia z mssql");
            e.printStackTrace();
        }

    }

    public void AddClient(Client client) {
        try {
            String sql = String.format("INSERT INTO Client VALUES ('%s','%s','%s','%s','%s')", client.getName(), client.getSurname(), client.getBirthDate().toString(), client.getGender(), client.getId_bankAccount());

            connection = DriverManager.getConnection(DB_URL);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Doddawanie rekordow do tabeli");

    }

    public void AddBankAccount(BankAccount bankAccount){

        try {
            String sql = String.format("INSERT INTO BankAccount VALUES ('%s','%s')", bankAccount.getAccountNumber(),bankAccount.getBalance() );

            connection = DriverManager.getConnection(DB_URL);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void AddHistory(History history){

        try {
            String sql = String.format("INSERT INTO History VALUES ('%s','%s','%s','%s')", history.getId_bankAccount(),history.getPayType(),history.getMoneyAmount(),history.getOperationDate() );

            connection = DriverManager.getConnection(DB_URL);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
