package bank;

import javax.swing.*;

public class MainView  extends JFrame {
    private JPanel MainPanel;

    public MainView()  {
        super("MainView");
        this.setContentPane(this.MainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
}
