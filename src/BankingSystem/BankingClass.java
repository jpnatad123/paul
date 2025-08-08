package BankingSystem;

public class BankingClass {
    private final int storedAccountNo = 123456;
    private final int storedPin = 123143;

    public boolean verifyAccount(int accountNo, int pin) {
        return accountNo == storedAccountNo && pin == storedPin;
    }
}