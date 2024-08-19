import tasks.*;

public class Main {
    public static void main(String[] args) {
        createEmployee();
        createArrayOfEmployees();
        saveAttractionsInfo();
    }

    public static void createEmployee() {
        Employee employee = new Employee("Акснович Иван Александрович", "QA Automation", "aksnovich.ivan@gmail.com",
                "80333372258", 500, 26);
        employee.printEmployeeInfo();
    }

    public static void createArrayOfEmployees() {
        Employee[] persons = new Employee[5];
        persons[0] = new Employee("Науменко Александр Викторович", "QA Engineer Java", "Naumenko.ex@gmail.com",
                "80333376789 ", 1300, 29);
        persons[1] = new Employee("Зубенко Михаил Петрович", "QA Lead", "Zybenko.@gmail.com",
                "80336751510", 1500, 29);
        persons[2] = new Employee("Конорев Иван Алексеевич", "QA Engineer Java", "Knoria.ivan@gmail.com",
                "80333376789", 1300, 29);
        persons[3] = new Employee("Сопот Пётр Александрович", "QA Engineer Java", "Sopotom@gmail.com",
                "80333376789 ", 1000, 28);
        persons[4] = new Employee("Разумихин Василий Степанович", "QA Engineer Java", "Razymihin@gmail.com",
                "80333582607", 1100, 26);
        // метод для вывода массива в консоль
        /*for (Employee index : persons) {
            System.out.println(index);
        }*/
    }

    public static void saveAttractionsInfo() {
        Park gorkyPark = new Park("Парк Горького");
        gorkyPark.attractionAdd("Колесо обозрения", "с 10:00 до 20:00", 11.5);
        // метод для вывода информации в консоль
        //gorkyPark.printAttraction();
    }
}
