package bank.models;

// Historia
// id
// id_rachunku
// typ: wpłata/wypłata
// kwota

import java.time.LocalDate;
import java.util.Date;

public class History {

    int id;
    int id_bankAccount;
    PayType payType;
    float moneyAmount;
    LocalDate operationDate;

    public History(int id_bankAccount, PayType payType, float moneyAmount, LocalDate operationDate) {
        this.id_bankAccount = id_bankAccount;
        this.payType = payType;
        this.moneyAmount = moneyAmount;
        this.operationDate = operationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_bankAccount() {
        return id_bankAccount;
    }

    public void setId_bankAccount(int id_bankAccount) {
        this.id_bankAccount = id_bankAccount;
    }

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    public float getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(float moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public LocalDate getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate;
    }


}
