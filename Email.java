package emailApp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 15;
    private String alternateEmail;
    private String companySuffix = "xyzcompany.org";

    public Email() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first name: ");
        this.firstName = input.next();
        System.out.print("Enter the last name: ");
        this.lastName = input.next();
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        this.department = setDepartment();

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    private String setDepartment() {
        System.out.print("New Worker: " + firstName + 
            "\nDEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the department code: ");
        Scanner input = new Scanner(System.in);
        int depChoice = input.nextInt();
        if (depChoice == 1) return "sales";
        else if (depChoice == 2) return "dev";
        else if (depChoice == 3) return "acct";
        return "";
    }

    private String randomPassword(int length) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your password (leave empty to auto-generate): ");
        String userInput = input.nextLine().trim();

        if (!userInput.isEmpty()) {
            return userInput;
        } else {
            String passwordSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&*";
            char[] password = new char[length];
            for (int i = 0; i < length; i++) {
                int rand = (int) (Math.random() * passwordSet.length());
                password[i] = passwordSet.charAt(rand);
            }
            return new String(password);
        }
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    public void setMailboxCapacity(int capacity) { this.mailboxCapacity = capacity; }
    public void setAlternateEmail(String altEmail) { this.alternateEmail = altEmail; }
    public void changePassword(String password) { this.password = password; }

    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail() { return alternateEmail; }
    public String getPassword() { return password; }

    public String showInfo() {
        return "FirstName: " + firstName + "\n" +
               "LastName: " + lastName + "\n" +
               "Email: " + email + "\n" +
               "Mailbox capacity: " + mailboxCapacity;
    }
}
