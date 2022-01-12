package bank;

import bank.database.Database;
import bank.models.BankAccount;
import bank.models.Client;
import bank.models.History;
import bank.models.PayType;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class MainView extends JFrame {
    private JPanel MainPanel;
    private JToolBar MainToolBar;
    private JList clientsList;
    private JScrollBar scrollBar1;
    private JLabel historyLabel;
    private JList historyList;
    private JScrollBar scrollBar2;
    private JTextField paymentValuetextField;
    private JButton buttonAddPayment;
    private JButton buttonPayOut;
    private JLabel BalanceLabelText;
    private JLabel AccountBalanceLabel;
    private ArrayList<Client> clients;
    private DefaultListModel listClientsModel;


    private JMenuBar menuBar;
    private JTextField menuSearchTextField;
    private JLabel menuSearchLabel;
    private JToolBar.Separator separatorToolBar;
    private JMenu menuClients, menuSort;
    private JMenuItem addClient, fromAccountBalance, fromSurname;

    private Client selectedClient;
    // Klient
    // id
    // imie
    // nazwisko
    // płeć
    // data_urodzenia
    // id_rachunku

    // Rachunek
    // id
    // numer_konta
    // stan_konta => 220
    // data_wpłaty => data wpłaty 20 pln
    // data_Wyplaty

    // Historia
    // id
    // id_rachunku
    // typ: wpłata/wypłata
    // kwota


    public MainView() {
        super("MainView");
        this.setContentPane(this.MainPanel); // komponent poczatkowy
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        menuBar = new JMenuBar();

        menuClients = new JMenu("Klienci");
        menuSort = new JMenu("Sortuj według");

        menuBar.add(menuClients);
        menuBar.add(menuSort);


        addClient = new JMenuItem("Dodaj Klienta");
        menuClients.add(addClient);

        fromAccountBalance = new JMenuItem("Najwyższego Stanu Konta");
        fromAccountBalance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Database database = new Database();
                clients = database.GetClientsByBalance();

                listClientsModel = new DefaultListModel(); //żeby wyświetlic liste klientów
                for (int i = 0; i < clients.size(); i++) {
                    listClientsModel.addElement(clients.get(i));
                }
                clientsList.setModel(listClientsModel);

            }
        });
        menuSort.add(fromAccountBalance);


        MainToolBar.add(menuBar);

        separatorToolBar = new JToolBar.Separator();
        MainToolBar.add(separatorToolBar);

        menuSearchLabel = new JLabel("Szukaj numeru konta  ");
        MainToolBar.add(menuSearchLabel);

        menuSearchTextField = new JTextField(); // dodac szukaj przed prezentacja
        MainToolBar.add(menuSearchTextField);

        addClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateClientView createClientView = new CreateClientView();
                createClientView.setSize(410, 400);
                createClientView.setVisible(true);

            }
        });
        Database database = new Database();
        clients = database.GetClients();

        listClientsModel = new DefaultListModel(); //żeby wyświetlic liste klientów
        for (int i = 0; i < clients.size(); i++) {
            listClientsModel.addElement(clients.get(i));
        }
        clientsList.setModel(listClientsModel);


        menuSearchTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (menuSearchTextField.getText().isEmpty()) {
                    clients = database.GetClients();

                    listClientsModel = new DefaultListModel(); //żeby wyświetlic liste klientów
                    for (int i = 0; i < clients.size(); i++) {
                        listClientsModel.addElement(clients.get(i));
                    }
                    clientsList.setModel(listClientsModel);
                    return;
                }

                BankAccount getBankAccount = database.GetBankAccountById(Integer.parseInt(menuSearchTextField.getText())); // zmieniamy typ ze stringa na inta
                // account number

                if (getBankAccount != null) {

                    clientsList.setModel(new DefaultListModel()); // ustawiliśmy ppusty model ( jakby czysta lista )

                    getBankAccount.getId();// szukam klienta który get bank account id jest równe temu id
                    //to jest klasa reprezentująca konto bankowe i pobranie jego id
                    //Dopasowanie id rachunku do id_bank account klienta

                    // zmienna reprezentująca klienta na podstawie pustego konstruktora

                    Client client1 = new Client();


                    //int i=0; i<clients.size();i++)
                    //Client clientForContext: clients


                    for (int i = 0; i < clients.size(); i++) {
                        Client clientForContext = (clients.get(i));

                        if (clientForContext.getId_bankAccount() == getBankAccount.getId()) {
                            client1 = clientForContext;
                            break;
                        }

                    }

                    listClientsModel = new DefaultListModel(); //nowy model listy dla jlist
                    listClientsModel.addElement(client1); // znaleziony klient dodajemy do nowej listy

                    clientsList.setModel(listClientsModel); // ustawimy to jako nowy model listy

                }
            }
        });


        clientsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    historyList.setModel(new DefaultListModel());
                    selectedClient = (Client) clientsList.getSelectedValue();
                    ArrayList<History> history = database.GetHistory(selectedClient.getId_bankAccount());
                    DefaultListModel listHistorysModel = new DefaultListModel(); //żeby wyświetlic liste transakcji

                    BankAccount selectedClientBankAccount = database.GetBankAccountById(selectedClient.getId_bankAccount());
                    AccountBalanceLabel.setText(String.valueOf(0)); // jesli nie znajdzie konta to wyswietlamy 0
                    if (selectedClientBankAccount != null) {
                        AccountBalanceLabel.setText(String.valueOf(selectedClientBankAccount.getBalance()));
                    }

                    if (history.size() == 0) {
                        return;
                    }
                    for (int i = 0; i < history.size(); i++) {
                        listHistorysModel.addElement(history.get(i));
                    }
                    historyList.setModel(listHistorysModel);
                }
            } //funkcja wybiera klienta
        });


        buttonAddPayment.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                BankAccount selectedClientBankAccount = database.GetBankAccountById(selectedClient.getId_bankAccount());
                float money = Float.parseFloat(paymentValuetextField.getText());
                database.UpdateBalance(selectedClient.getId_bankAccount(), selectedClientBankAccount.getBalance() + money);
                database.AddHistory(new History(selectedClient.getId_bankAccount(), PayType.Payment, money, LocalDate.now()));


                ArrayList<History> history = database.GetHistory(selectedClient.getId_bankAccount());
                DefaultListModel listHistorysModel = new DefaultListModel(); //żeby wyświetlic liste transakcji

                selectedClientBankAccount = database.GetBankAccountById(selectedClient.getId_bankAccount());
                AccountBalanceLabel.setText(String.valueOf(0)); // jesli nie znajdzie konta to wyswietlamy 0
                if (selectedClientBankAccount != null) {
                    AccountBalanceLabel.setText(String.valueOf(selectedClientBankAccount.getBalance()));
                }

                if (history.size() == 0) {
                    return;
                }
                for (int i = 0; i < history.size(); i++) {
                    listHistorysModel.addElement(history.get(i));
                }
                historyList.setModel(listHistorysModel);

                paymentValuetextField.setText("");//czyszczenie pola tesktowego
            }
        });

        buttonPayOut.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                float money = Float.parseFloat(paymentValuetextField.getText());
                BankAccount selectedClientBankAccount = database.GetBankAccountById(selectedClient.getId_bankAccount()); //Pobieramy konto bankowe wybranego klienta by sprawdzic czy jego stan pozwala na wypłate
                if (selectedClientBankAccount.getBalance() - money < 0) {
                    JOptionPane.showMessageDialog(null, "Nie masz środków na koncie ", "Błąd", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                database.UpdateBalance(selectedClient.getId_bankAccount(), selectedClientBankAccount.getBalance() - money);// aktualizujemy historie
                database.AddHistory(new History(selectedClient.getId_bankAccount(), PayType.Payout, money * (-1), LocalDate.now())); //dodajemy do histori

                //odżwiezanie listy i czyszczenie text fielda
                ArrayList<History> history = database.GetHistory(selectedClient.getId_bankAccount());
                DefaultListModel listHistorysModel = new DefaultListModel(); //żeby wyświetlic liste transakcji

                selectedClientBankAccount = database.GetBankAccountById(selectedClient.getId_bankAccount());
                AccountBalanceLabel.setText(String.valueOf(0)); // jesli nie znajdzie konta to wyswietlamy 0
                if (selectedClientBankAccount != null) {
                    AccountBalanceLabel.setText(String.valueOf(selectedClientBankAccount.getBalance()));
                }

                if (history.size() == 0) {
                    return;
                }
                for (int i = 0; i < history.size(); i++) {
                    listHistorysModel.addElement(history.get(i));
                }
                historyList.setModel(listHistorysModel);

                paymentValuetextField.setText("");//czyszczenie pola tesktowego


            }
        });
    }
}
