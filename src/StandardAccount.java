public class StandardAccount implements IAccount{

    int accountNumber;
    double creditLimit;
    double balance;

    public StandardAccount(int accountNumber,double creditLimit) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;

        this.creditLimit = creditLimit < 0 ? creditLimit : 0;
    }

    @Override
    public void Deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        double availableMoney = this.balance - this.creditLimit;

        if(availableMoney >= amount) {
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