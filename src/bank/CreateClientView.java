package bank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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


    public CreateClientView() {
        super("Dodawanie Klienta");
        this.setContentPane(this.mainPanel); // komponent poczatkowy
        this.pack();

        addPaymentPanel.setVisible(false);
        yesCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (yesCheckBox.isSelected()) {
                    addPaymentPanel.setVisible(true);
                }
                if (!yesCheckBox.isSelected()) {
                    addPaymentPanel.setVisible(false);
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (allFieldsAreValid()) {
                    System.out.println("Dodaje Ola ja kilentów");
                }
            }
        });
    }

    private boolean allFieldsAreValid() {
        if (areFieldsEmpty() || !areFormatsValid()) {
            return false;
        }

        return true;
    }

    private boolean areFieldsEmpty() {
        if (textFieldName.getText().equals("") || textFieldSurname.getText().equals("") || textFieldDateBirth.getText().equals("") || textFieldAccountNumber.getText().equals("")) {
            return true;
        }

        return false;
    }

    private boolean areFormatsValid() {
        try {
            LocalDate date = LocalDate.parse(textFieldDateBirth.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            int accountNumber = Integer.parseInt(textFieldAccountNumber.getText());
        } catch (Exception exception) {
            return false;
        }
// jesli format jest niepoprawny to metoda parse wyrzuca wyjątek który łapiemy i wtedy zwracmy fałsz
// jeśli wyjątek nie zostanie wyrzucony to znaczy że formaty są poprawne i zwracamy prawde czyli areFormatsValid() = true
        return true;
    }
}
