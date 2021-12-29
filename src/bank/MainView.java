package bank;

import javax.swing.*;

public class MainView extends JFrame {
    private JPanel MainPanel;
    private JToolBar MainToolBar;

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
        this.setContentPane(this.MainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
}
