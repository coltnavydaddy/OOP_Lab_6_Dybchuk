
import java.util.Scanner;


abstract class Man {
    private String surname;
    private String name;
    private int age;

    public void setSurname(String surname) {this.surname = surname;}
    public void setName(String name) {this.name = name;}
    public void setAge(int age) {this.age = age;}

    public String getSurname() {return surname;}
    public String getName() {return name;}
    public int getAge() {return age;}

    public abstract void printInfo();
}
class Person extends Man {
    @Override
    public void printInfo() {System.out.println("Людина (П.І.): " + getSurname() + " " + getName() + ", його(її) вік: " + getAge() + '\n');
    }
}
class Student extends Man {
    private int group;
    private int cardNumber;

    public void setGroup(int group) {this.group = group;}
    public void setCardNumber(int cardNumber) {this.cardNumber = cardNumber;}

    public int getGroup() {return group;}
    public int getCardNumber() {return cardNumber;}

    @Override
    public void printInfo() {System.out.println("Студент " + getGroup() + " групи " + "," +getSurname() + " " + getName() +
            ", його(її) вік: " + getAge() + ". \nНомер картки студенту: " + getCardNumber() + '\n');
    }
}

class Lecturer extends Man {
    private String department;
    private int salary;

    public void setDepartment(String chair) {this.department = chair;}
    public void setSalary(int salary) {this.salary = salary;}

    public float getSalary() {return salary;}
    public String getDepartment() {return department;}

    @Override
    public void printInfo() {
        System.out.println("Лектор " + getDepartment() + " кафедри " + getSurname() + " " + getName() +
                ", вік: " + getAge() + ". \nЗарплатня: " + getSalary() + '\n');
    }
}

public class ClassMain {

    public static void main(String [] args) {

        System.out.println("Введіть дані про людину:");
        Scanner in = new Scanner(System.in);
        Man[] people = new Man[4];

        System.out.println('\n' + "Персони:");
        for (int i = 0; i < 2; i++) {

            Man person = new Person();

            System.out.println("Введіть прізвище: ");
            person.setSurname(in.next() );

            System.out.println("Введіть ім'я: ");
            person.setName(in.next() );

            System.out.println("Введіть вік: ");
            person.setAge(in.nextInt() );
            people[i] = person;
        }

        System.out.println('\n' + "Студенти: ");
        for (int i = 2; i < 3; i++) {

            Man student = new Student();

            System.out.println("Введіть прізвище: ");
            student.setSurname(in.next() );

            System.out.println("Введіть ім'я: ");
            student.setName(in.next() );

            System.out.println("Введіть вік: ");
            student.setAge(in.nextInt() );

            System.out.println("Введіть групу: ");
            Student student2 = (Student) student;
            student2.setGroup(in.nextInt() );

            System.out.println("Введіть номер картки студента: ");
            student2.setCardNumber(in.nextInt() );
            people[i] = student;
        }

        System.out.println('\n' + "Лектори:");
        for (int i = 3; i < 4; i++) {

            Man lecturer = new Lecturer();

            System.out.println("Введіть прізвище: ");
            lecturer.setSurname(in.next() );

            System.out.println("Введіть ім'я: ");
            lecturer.setName(in.next() );

            System.out.println("Введіть вік: ");
            lecturer.setAge(in.nextInt() );

            System.out.println("Введіть кафедру: ");
            Lecturer lecturer3 = (Lecturer) lecturer;
            lecturer3.setDepartment((in.next() ) );

            System.out.println("Введіть зарплатню: ");
            lecturer3.setSalary(in.nextInt() );
            people[i] = lecturer;
        }

        for (int i = 0; i < 4; i++) {
            people[i].printInfo();
        }
    }
}