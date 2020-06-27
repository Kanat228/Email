package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    //Constructor to receive the first name and last name
    //Конструктор для получения имени и фамилии
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //Call a method asking for the department - return the department
        //Вызовите метод, запрашивающий отдел - верните отдел
        this.department = setDepartment();

        //Call a method that returns a random password
        //Вызов метода, возвращающего случайный пароль
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //Combine elements to generate email
        //Комбинируйте элементы для создания электронной почты
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    //Ask for the department
    //Спросите в отделе
    private String setDepartment() {
        System.out.print("New worker: " + firstName + ". Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "Sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acct";
        } else {
            return "";
        }
    }

    //Generate a random password
    //Генерировать случайный пароль
    private String randomPassword(int length) {
        String passwordSet = "ABSDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set the mailbox capacity
    //Установите емкость почтового ящика
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    //Создать альтернативную почту
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    //Change the password
    //Изменить пароль
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
