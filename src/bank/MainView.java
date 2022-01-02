package bank;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private JPanel MainPanel;
    private JToolBar MainToolBar;
    private JTable ClientsTable;
    private JMenuBar menuBar;
    private JTextField menuSearchTextField;
    private JLabel menuSearchLabel;
    private JToolBar.Separator separatorToolBar;
    private JMenu menuClients, menuSort;
    private JMenuItem addClient, fromAccountBalance, fromSurname;


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
        menuSort.add(fromAccountBalance);

        fromSurname = new JMenuItem("Nazwiska (A-Z) ");
        menuSort.add(fromSurname);

        MainToolBar.add(menuBar);

        separatorToolBar = new JToolBar.Separator();
        MainToolBar.add(separatorToolBar);

        menuSearchLabel = new JLabel("Szukaj numeru konta  ");
        MainToolBar.add(menuSearchLabel);

        menuSearchTextField = new JTextField(" Szukaj");
        MainToolBar.add(menuSearchTextField);


    }
}
