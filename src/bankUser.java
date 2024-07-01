import javax.swing.*;

public class bankUser extends AbstractBankUser {
    public String name = "";
    public int id = 0;
    public double balance = 0;

    bankUser(String name, int id, double balance) throws ArithmeticException, myCustomException {
        setName(name);
        setId(id);
        if (balance < 0) {
            if ((id & 1) > 0) {
                throw new myCustomException("Try Again with a valid balance");
            } else {
                throw new ArithmeticException("Invalid Balance, Balance must be greater than 0");
            }
        }
        setBalance(balance);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) throws ArithmeticException, myCustomException {
        if (balance < 0) {
            if ((id & 1) > 0) {
                throw new myCustomException("Try Again with a valid balance");
            } else {
                throw new ArithmeticException("Invalid Balance, Balance must be greater than 0");
            }
        }
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws ArithmeticException, myCustomException {
        if (amount > 0) {
            balance += amount;
            JOptionPane.showMessageDialog(null, "Added Successfully");
        } else {
            if ((id & 1) > 0) {
                throw new myCustomException("Try Again with a valid balance");
            } else {
                throw new ArithmeticException("Invalid Balance, Balance must be greater than 0");
            }
        }
    }

    public void withdraw(double amount) throws ArithmeticException, myCustomException {
        if (amount > balance) {
            if ((id & 1) > 0) {
                throw new myCustomException("Try Again with a valid balance");
            } else {
                throw new ArithmeticException("Invalid Balance, Not Enough Balance");
            }
        } else if (amount < 0) {
            if ((id & 1) > 0) {
                throw new myCustomException("Try Again with a valid balance");
            } else {
                throw new ArithmeticException("Invalid Balance, Balance must be greater than 0");
            }
        } else {
            balance -= amount;
            JOptionPane.showMessageDialog(null, "Withdrew Successfully");
        }
    }
}

