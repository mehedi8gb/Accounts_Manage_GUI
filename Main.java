
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import oop1.Book;
import oop1.Contact;
import oop1.Mobile;

public class Main {
    public static void main(String[] args) {
        int optn;
        // objects
        Book book = new Book("this is Book Class parameterize constructor");
        Contact contact = new Contact("this is Contact class parameterize constructor");
        Mobile mobile = new Mobile("this is Mobile Class parameterize constructor");
        // options
        String[] options = { "Book", "Contact", "Mobile", "Exit" };
        String[] bookOptions = { "Add Book", "Show Details" };
        String[] contactOptions = { "Add Book", "Show Details" };
        String[] mobileOptions = { "Add", "Show", "Call Someone" };
        // main icon
        ImageIcon mainicon = new ImageIcon("assets/main.png");
        while (true) {
            optn = JOptionPane.showOptionDialog(null, "Choose your option !",
                    "Main Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, mainicon, options, null);

            if (optn == 0) {
                int bookoptn = JOptionPane.showOptionDialog(null, "You can add books and show details!",
                        "Book Section", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, book.bookicon,
                        bookOptions, null);
                if (bookoptn == 0) {
                    book.setBookInfo();
                    book.showTotalBookInfo();
                } else if (bookoptn == 1) {
                    book.showTotalBookInfo();
                }

            } else if (optn == 1) {

                int contactoptn = JOptionPane.showOptionDialog(null, "You can add person data and show them!",
                        "Person Section", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        contact.contactIcon, contactOptions, null);
                if (contactoptn == 0) {
                    contact.setInfo();
                    contact.ShowPersonInfo();
                } else if (contactoptn == 1) {
                    contact.ShowPersonInfo();
                }

            } else if (optn == 2) {

                int mbloptn = JOptionPane.showOptionDialog(null, "Want to call or add data!",
                        "Mobile Section", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        mobile.mobileicon, mobileOptions, null);
                if (mbloptn == 0) {
                    mobile.setInfo();
                    mobile.ShowInfo();
                } else if (mbloptn == 1) {
                    mobile.ShowInfo();
                } else if (mbloptn == 2) {
                    mobile.showCurrentBalance();
                }

            } else if (optn == 3) {
                System.exit(0);
            }
        }

    }
}