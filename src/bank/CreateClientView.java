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
    private JLabel addLabel1;
    private JCheckBox yesCheckBox;
    private JPanel addPaymentPanel;
    private JLabel addPaymentLabel;
    private JTextField textFieldAddPayment;
    private JLabel dateLabel;
    private JTextField textFieldDate;
    private JPanel buttonPanel;
    private JButton saveButton;
    private JButton closeButton;


    public CreateClientView (){
      super("Dodawanie Klienta");
      this.setContentPane(this.mainPanel); // komponent poczatkowy
      this.pack();
  }
}
