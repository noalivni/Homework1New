public class BasicAccount implements IAccount {

    int accountNumber;
    double withdrawalLimit;
    double balance;

    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.accountNumber = accountNumber;
        this.withdrawalLimit = withdrawalLimit > 0 ? withdrawalLimit : 0;
        this.balance = 0.0;
    }

    @Override
    public void Deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        double availableMoney = this.balance;


        if (amount > this.withdrawalLimit) {
            amount = this.withdrawalLimit;
        }

        if (availableMoney >= amount) {
            this.balance -= amount;
            return amount;
        }

        this.balance -= availableMoney;
        return availableMoney;
    }

    @Override
    public double GetCurrentBalance() {
        return this.balance;
    }

    @Override
    public int GetAccountNumber() {
        return this.accountNumber;
    }
}