package carshop.impl;

import carshop.cars.*; // імпортуємо усі класи з пакету "cars" завдяки *;

import carshop.interf.Admin;
import carshop.interf.Customer;

import java.util.Scanner;

public class MyOwnAutoShop implements Admin, Customer {
    @Override
    public double getIncome() {
        double income = 0;
        for (Car car : Shop) {
            if (car.isSellOut) income += car.getSalePrice(car.regularPrice); }
        return income;
    }
    @Override
    public void getCarsPrice() {
        for (Car car : Shop) { System.out.println(car.regularPrice); }
    }
    @Override
    public void getCarsColors() {
        for (Car car : Shop) { System.out.println(car.color); }
    }

    @Override
    public double getCarPrice(int id) { return Shop[id].getSalePrice(Shop[id].regularPrice); }
    @Override
    public String getCarColor(int id) { return Shop[id].color; }
    @Override
    public void purchaseCar(int id) { Shop[id].isSellOut = true; }
    Car[] Shop = new Car[5];
    {
        Sedan Sedan_ = new Sedan();

        Shop[0] = Sedan_;

        Ford Ford_1 = new Ford();
        Shop[1] = Ford_1;
        Ford Ford_2 = new Ford();
        Shop[2] = Ford_2;

        Truck Truck_1 = new Truck();
        Shop[3] = Truck_1;
        Truck Truck_2 = new Truck();
        Shop[4] = Truck_2;

        Scanner in = new Scanner(System.in);
        System.out.println("Введіть дані:"+'\n');

        System.out.println("Дані про Седан(и):");
        System.out.println("Швидкість машини: ");
        Sedan_.setSpeed(in.nextInt());
        System.out.println("Введіть ціну машини: ");
        Sedan_.setRegularPrice(in.nextInt());
        System.out.println("Введіть колір машини: ");
        Sedan_.setColor(in.next());
        System.out.println("Введіть довжину машини: ");
        Sedan_.setLength(in.nextInt());


        for (int i = 1; i < 3; i++) {

            System.out.println("Введіть дані про Форд(и)" + '\n');
            System.out.println("Швидкість машини: ");
            Shop[i].setSpeed(in.nextInt());

            System.out.println("Введіть ціну машини: ");
            Shop[i].setRegularPrice(in.nextInt());

            System.out.println("Введіть колір машини: ");
            Shop[i].setColor(in.next());

            System.out.println("Введіть рік, коли було зроблено машину: ");
            if (i==2) { Ford_1.setYear(in.nextInt());}
            else {Ford_2.setYear(in.nextInt());}

            System.out.println("Введіть знижку від виробника: ");
            if (i==2) { Ford_1.setManufacturerDiscount(in.nextInt());}
            else {Ford_2.setManufacturerDiscount(in.nextInt());}
        }


        for (int i = 3; i < 5; i++) {

            System.out.println("Введіть дані про Трак(и)" + '\n');
            System.out.println("Швидкість машини: ");
            Shop[i].setSpeed(in.nextInt());

            System.out.println("Введіть ціну машини: ");
            Shop[i].setRegularPrice(in.nextInt());

            System.out.println("Введіть колір машини: ");
            Shop[i].setColor(in.next());

            System.out.println("Введіть вагу машини: ");
            if (i==4) { Truck_1.setWeight(in.nextInt());}
            else {Truck_2.setWeight(in.nextInt());}

        }

        System.out.println('\n'+ "Вітаємо!!!");

        System.out.println("Введіть айді машини, щоб подивитися на її характеристики та ціну: ");

        int idi = in.nextInt() - 1;
        while ( idi!= 5) {
            System.out.println("Ціна: " + getCarPrice(idi) );
            System.out.println("Кольор: " + getCarColor(idi) );

            idi = in.nextInt() - 1;
        }

        System.out.println("Введіть айді щоб купити машину (введіть 6 для закінчення): ");

        System.out.println("Айді (5 для закінчення): ");
        idi = in.nextInt() - 1;

        while (idi != 5) {
            purchaseCar(idi);
            System.out.println("Машину під айді номер " + idi + " куплено!");
            System.out.println("Айді (6 для закінчення): ");
            idi = in.nextInt() - 1;
        }

        in.close();

        System.out.println('\n' + "Дохід автопрому: " + getIncome() );
    }
}