
import java.util.Scanner;

interface Man {

     void setSurname(String surname);

     void setName(String name);

     void setAge(int age);

     String getSurname();

     String getName();

     int getAge();

     void printInfo();
}

class Person implements Man {
    private String surname;
    private String name;
    private int age;
    @Override
    public void setSurname(String surname) {this.surname = surname;}

    @Override
    public void setName(String name) {this.name = name;}

    @Override
    public void setAge(int age) {this.age = age;}

    @Override
    public String getSurname() {return surname;}

    @Override
    public String getName() {return name;}

    @Override
    public int getAge() {return age;}

    @Override
    public void printInfo() {System.out.println("Людина (П.І.): " + getSurname() + " " + getName() + ", його(її) вік: " + getAge() + '\n');
    }
}
class Student extends Person {
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

class Lecturer extends Person {
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

public class InterfaceMain {

    public static void main(String [] args) {

        System.out.println("Введіть дані про людину:");
        Scanner in = new Scanner(System.in);
        Person[] people = new Person[4];

        System.out.println('\n' + "Персони:");
        for (int i = 0; i < 2; i++) {

            Person person = new Person();

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

            Person student = new Student();

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

            Person lecturer = new Lecturer();

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