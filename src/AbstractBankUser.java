abstract class AbstractBankUser {
    abstract void setName(String name);

    abstract void setId(int id);

    abstract void setBalance(double balance) throws ArithmeticException, myCustomException;

    abstract String getName();

    abstract int getId();

    abstract double getBalance();

    abstract void deposit(double amount) throws ArithmeticException, myCustomException;

    abstract void withdraw(double amount) throws ArithmeticException, myCustomException;
}
