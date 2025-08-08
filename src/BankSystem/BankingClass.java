package BankSystem;

public class BankingClass {
    private final int storedAccountNo = 123123;
    private final int storedPin = 137982;

    public boolean verifyAccount(int accountNo, int pin) {
        return accountNo == storedAccountNo && pin == storedPin;
    }
}