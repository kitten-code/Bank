package bank;

import javax.swing.*;

public class CreateClientView extends JFrame {
    private JTextField textFieldName;
    private JTextField textFieldSurname;
    private JTextField textFieldDateBirth;
    private JTextField textFieldAccountNumber;
    private JPanel mainPanel;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel birthDateLabel;
    private JLabel AccountNumberLabel;
    private JLabel genderLabel;
    private JRadioButton femaleRadioButton;
    private JRadioButton maleRadioButton;


    public CreateClientView (){
      super("MainView");
      this.setContentPane(this.mainPanel); // komponent poczatkowy
      this.pack();
  }
}
