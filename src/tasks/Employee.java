package tasks;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private double salary;
    private int yearsOld;

    public Employee(String fullName, String position, String email, String phoneNumber, double salary, int yearsOld) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.yearsOld = yearsOld;
    }

    public void printEmployeeInfo() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Номер телефона: " + phoneNumber);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + yearsOld);
    }

    public String toString() {
        return "ФИО: " + fullName + ", " + "Должность: " + position + ", " + "Email: " + email + ", " + "Номер телефона: " + phoneNumber + ", " + "Зарплата: " + salary + " руб, " + "Возраст: " + yearsOld + " лет.";
    }
}