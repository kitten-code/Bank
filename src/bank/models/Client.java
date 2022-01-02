package bank.models;

import java.time.LocalDate;
import java.util.Date;


public class Client {

    int id;
    String name;
    String surname;
    LocalDate birthDate;
    Gender gender;
    int id_bankAccount;

    public Client(String name, String surname, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
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
