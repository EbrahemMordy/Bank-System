import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<bankUser> users = new ArrayList<>();
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        //three types of queries
        int x = 1;
        while (true) {
            //create msg dialog
            String type = JOptionPane.showInputDialog(null, """
                    Enter the type of query\s
                    1. Add User
                    2. Deposit
                    3. Withdraw
                    4. Get User
                    5. Exit""");
            try {
                x = Integer.parseInt(type);
            } catch (Exception _) {
                JOptionPane.showMessageDialog(null, "Invalid Input");
                break;
            }
            int id;
            if (x == 1) {
                String name = JOptionPane.showInputDialog(null, "Enter the name");
                type = JOptionPane.showInputDialog(null, "Enter the id");
                try {
                    id = Integer.parseInt(type);
                } catch (Exception _) {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                    break;
                }
                double balance;
                type = JOptionPane.showInputDialog(null, "Enter the Balance");
                try {
                    balance = Double.parseDouble(type);
                } catch (Exception _) {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                    break;
                }
                try {
                    bankUser u = new bankUser(name, id, balance);
                    users.add(u);
                } catch (ArithmeticException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                } catch (myCustomException e) {
                    JOptionPane.showMessageDialog(null, "Own Exception: " + e.getMessage());
                }
                JOptionPane.showMessageDialog(null, "Added Successfully");
                mp.put(id, users.size() - 1);
            } else if (x == 2) {
                type = JOptionPane.showInputDialog(null, "Enter the id");
                try {
                    id = Integer.parseInt(type);
                } catch (Exception _) {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                    break;
                }
                double amount;
                type = JOptionPane.showInputDialog(null, "Enter the Balance");
                try {
                    amount = Double.parseDouble(type);
                } catch (Exception _) {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                    break;
                }
                Integer val = mp.get(id);
                if (val == null) {
                    JOptionPane.showMessageDialog(null, "User not found");
                    continue;
                }
                try {
                    users.get(val).deposit(amount);
                } catch (ArithmeticException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                } catch (myCustomException e) {
                    JOptionPane.showMessageDialog(null, "Own Exception: " + e.getMessage());
                }
            } else if (x == 3) {
                type = JOptionPane.showInputDialog(null, "Enter the id");
                try {
                    id = Integer.parseInt(type);
                } catch (Exception _) {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                    break;
                }
                double amount;
                type = JOptionPane.showInputDialog(null, "Enter the Balance");
                try {
                    amount = Double.parseDouble(type);
                } catch (Exception _) {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                    break;
                }
                Integer val = mp.get(id);
                if (val == null) {
                    JOptionPane.showMessageDialog(null, "User not found");
                    continue;
                }
                try {
                    users.get(val).withdraw(amount);
                } catch (ArithmeticException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                } catch (myCustomException e) {
                    JOptionPane.showMessageDialog(null, "Own Exception: " + e.getMessage());
                }
            } else if (x == 4) {
                type = JOptionPane.showInputDialog(null, "Enter the id");
                try {
                    id = Integer.parseInt(type);
                } catch (Exception _) {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                    break;
                }
                Integer val = mp.get(id);
                if (val == null) {
                    JOptionPane.showMessageDialog(null, "User not found");
                    continue;
                }
                JOptionPane.showMessageDialog(null, "Name: " + users.get(val).getName() + "\n" + "Balance: " + users.get(val).getBalance());
            } else {
                JOptionPane.showMessageDialog(null, "Exiting");
                break;
            }
        }
    }
}