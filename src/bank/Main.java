package bank;

import bank.database.Database;

public class Main {

    public static void main(String[] args) {
        MainView mainView = new MainView();
        mainView.setSize(1640,1200);
        mainView.setVisible(true);

        new Database();
    }
}
