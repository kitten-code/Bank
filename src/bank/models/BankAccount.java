package bank.models;

public class BankAccount {
    int id;
    int accountNumber;
    float balance;

    public BankAccount(){

    }

    public BankAccount( int accountNumber,float balance) {
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
