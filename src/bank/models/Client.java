package bank.models;

import java.sql.Date;
import java.time.LocalDate;


public class Client {

    int id;
    String name;
    String surname;
    LocalDate birthDate;
    Gender gender;
    int id_bankAccount;

    public Client(String name, String surname, LocalDate birthDate, Gender gender, int id_bankAccount) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
        this.id_bankAccount = id_bankAccount;
    }

    public Client(int id, String name, String surname, Date birthDate, String gender, int id_bankAccount) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate.toLocalDate();
        this.gender = Gender.valueOf(gender); //konwertuje stringa na enuma
        this.id_bankAccount = id_bankAccount;
    }

    @Override
    public String toString() {
        return "Client " +
                "  " + id +
                "  " + name +
                " " + surname +
                "   Data ur.  " + birthDate +
                " ( " + gender + " ) "+
                " numer konta: " + id_bankAccount
                ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getId_bankAccount() {
        return id_bankAccount;
    }

    public void setId_bankAccount(int id_bankAccount) {
        this.id_bankAccount = id_bankAccount;
    }
}
