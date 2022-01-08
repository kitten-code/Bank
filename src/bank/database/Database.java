package bank.database;

import bank.models.BankAccount;
import bank.models.Client;
import bank.models.History;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

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

    // zwracam konto bankowe z bazy danych na podstawie numeru konta bankowego
    public BankAccount GetBankAccount(int bankAccountNumber) {
        BankAccount bankAccount = new BankAccount();
        try {
            String sql = String.format("SELECT * FROM BankAccount WHERE accountNumber = %s", bankAccountNumber);

            connection = DriverManager.getConnection(DB_URL);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                bankAccount.setId(rs.getInt("id"));
                bankAccount.setAccountNumber(rs.getInt("accountNumber"));
                bankAccount.setBalance(rs.getFloat("balance"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bankAccount;
    }

    public BankAccount GetBankAccountById(int id) {
        BankAccount bankAccount = new BankAccount();
        try {
            String sql = String.format("SELECT * FROM BankAccount WHERE id = %s", id);

            connection = DriverManager.getConnection(DB_URL);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                bankAccount.setId(rs.getInt("id"));
                bankAccount.setAccountNumber(rs.getInt("accountNumber"));
                bankAccount.setBalance(rs.getFloat("balance"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bankAccount;
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


    public ArrayList<Client> GetClients() {
        ArrayList<Client> clients=new ArrayList<Client>(); //clients - lista klientow
        try {
            String sql = "SELECT * FROM Client";

            connection = DriverManager.getConnection(DB_URL);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id =rs.getInt("id");
                String name =rs.getString("name");
                String surname =rs.getString("surname");
                Date birthDate =rs.getDate("birthDate");
                String gender =rs.getString("gender");
                int id_bankAccount =rs.getInt("id_bankAccount");

                Client client = new Client(id,name,surname,birthDate,gender,id_bankAccount); //obiekt klienta ( dane stworzone na podstawie typu
                clients.add(client);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;

    }






    public ArrayList<Client> GetClientsByBalance() {
        ArrayList<Client> clients=new ArrayList<Client>(); //clients - lista klientow
        try {
            String sql = "SELECT * FROM Client  INNER JOIN BankAccount ON BankAccount.id=Client.id_bankAccount\n" +
                    "    ORDER BY balance desc";

            connection = DriverManager.getConnection(DB_URL);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id =rs.getInt("id");
                String name =rs.getString("name");
                String surname =rs.getString("surname");
                Date birthDate =rs.getDate("birthDate");
                String gender =rs.getString("gender");
                int id_bankAccount =rs.getInt("id_bankAccount");

                Client client = new Client(id,name,surname,birthDate,gender,id_bankAccount); //obiekt klienta ( dane stworzone na podstawie typu
                clients.add(client);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;

    }





}
