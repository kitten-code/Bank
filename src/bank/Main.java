package bank;

import bank.database.Database;
import bank.models.*;

import java.time.LocalDate;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        MainView mainView = new MainView();
        mainView.setSize(1250,700);
        mainView.setVisible(true);

        Database database = new Database();
        //database.AddClient(new Client("Michal","Kot", LocalDate.now(), Gender.Female, 518532));
        //database.AddBankAccount(new BankAccount(3462,500));
        //database.AddHistory(new History(5,PayType.Payment,200,LocalDate.now()));
        //BankAccount account = database.GetBankAccount(3462);
    }


}
