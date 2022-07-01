package oop1;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Mobile {
    String[] mobileOptions = { "Recharge", "Call Someone", "Main Menu" };
    String mobileOwnerName;
    String mobileNumber; // SIM number
    double mobileBalance;
    String mobileOSName;
    boolean lock; // true means phone is lock false means unlock
    int duration;
    public ImageIcon mobileicon = new ImageIcon("assets/mobile.png");

    public Mobile() {
        System.out.println("Empty Constructor!");
    }

    public Mobile(String x) {

        System.out.println(x);
    }

    public void setInfo() {
        String[] options = { "Yes", "No" };
        this.mobileOwnerName = JOptionPane.showInputDialog("Enter Mobile Owner Name: ");
        this.mobileNumber = JOptionPane.showInputDialog("Enter Mobile Number : ");
        this.mobileBalance = Double.parseDouble(JOptionPane.showInputDialog("Enter Mobile Balance : "));
        this.mobileOSName = JOptionPane.showInputDialog("Enter Mobile OS Name : ");

        int opt = JOptionPane.showOptionDialog(null, "want to lock your phone? ", "mobile Information",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, mobileicon, options, options[1]);
        this.lock = (opt == 0);

    }

    public void ShowInfo() {

        if (this.mobileOSName != null) {
            String status = (this.lock == false) ? "unlocked" : "locked";
            JOptionPane.showMessageDialog(null,
                    " Mobile Owner Name: " + this.mobileOwnerName +
                            "\nMobile Balance : " + this.mobileBalance +
                            "\nNumber Number: " + this.mobileNumber +
                            "\nMobile OS Name : " + this.mobileOSName +
                            "\nPhone Status : " + status,
                    "---- Mobile information ----", JOptionPane.INFORMATION_MESSAGE, mobileicon);
        } else {
            JOptionPane.showMessageDialog(null,
                    "You have not added any data yet!",
                    "----oops----", JOptionPane.ERROR_MESSAGE);
        }
    }

    void Recharge(int amount) {
        this.mobileBalance += amount;
    }

    void callSomeone() {
        this.mobileBalance -= (Double) (duration * 0.5);
    }

    public void showCurrentBalance() {

        JOptionPane.showMessageDialog(null, "Your Current Balance is: " + this.mobileBalance,
                mobileOwnerName + "'s Balance Information", JOptionPane.INFORMATION_MESSAGE);
        int mbloptn = JOptionPane.showOptionDialog(null, "Want to recharge balance or call someone!",
                null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, mobileicon, mobileOptions, null);

        if (mbloptn == 0) {
            int tempBalance = Integer.parseInt(JOptionPane.showInputDialog("Add Balance : "));
            Recharge(tempBalance);
            showCurrentBalance();
        } else if (mbloptn == 1) {
            if (this.lock) {
                JOptionPane.showMessageDialog(null,
                        "Currently your phone status is locked you can not make any calls",
                        mobileOwnerName + "'s Balance Information", JOptionPane.INFORMATION_MESSAGE, mobileicon);
            } else if (this.mobileBalance == 0.0) {
                JOptionPane.showMessageDialog(null,
                        "Currently your balance is 0! you can not make any calls",
                        mobileOwnerName + "'s Balance Information", JOptionPane.INFORMATION_MESSAGE, mobileicon);
            } else {
                this.duration = Integer.parseInt(JOptionPane.showInputDialog("Enter Call Duration in minutes: "));
                callSomeone();
                showCurrentBalance();
            }
        }

    }
}
