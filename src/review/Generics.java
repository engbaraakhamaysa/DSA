package review;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    // ==========================
    // Generic Interface
    // ==========================
    interface Repository<T> {
        void save(T item);

        T findById(int index);
    }

    // ==========================
    // Student
    // ==========================
    static class Student {
        String name;
        double gpa;

        Student(String name, double gpa) {
            this.name = name;
            this.gpa = gpa;
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', gpa=" + gpa + "}";
        }
    }

    // ==========================
    // Employee
    // ==========================
    static class Employee {
        String name;
        double salary;

        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{name='" + name + "', salary=" + salary + "}";
        }
    }

    // ==========================
    // Generic Class
    // ==========================
    static class DataStore<T> implements Repository<T> {

        private List<T> list = new ArrayList<>();

        @Override
        public void save(T item) {
            list.add(item);
        }

        @Override
        public T findById(int index) {
            return list.get(index);
        }

        public void printAll() {
            for (T item : list) {
                System.out.println(item);
            }
        }
    }

    // ==========================
    // Multiple Generic Types
    // ==========================
    static class Pair<K, V> {

        private K key;
        private V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        void print() {
            System.out.println(key + " -> " + value);
        }
    }

    // ==========================
    // Generic Methods
    // ==========================
    static class Utils {

        public static <T> void print(T value) {
            System.out.println(value);
        }

        public static <T> void swap(List<T> list, int i, int j) {

            T temp = list.get(i);

            list.set(i, list.get(j));
            list.set(j, temp);
        }

        public static double sum(List<? extends Number> list) {

            double sum = 0;

            for (Number n : list) {
                sum += n.doubleValue();
            }

            return sum;
        }

        public static void addIntegers(List<? super Integer> list) {

            list.add(100);
            list.add(200);
            list.add(300);
        }

        public static void printList(List<?> list) {

            for (Object obj : list) {
                System.out.println(obj);
            }
        }
    }

    // ==========================
    // Main
    // ==========================
    public static void main(String[] args) {

        System.out.println("===== Generic Class =====");

        DataStore<Student> students = new DataStore<>();

        students.save(new Student("Ali", 95));
        students.save(new Student("Sara", 88));

        students.printAll();

        System.out.println();

        DataStore<Employee> employees = new DataStore<>();

        employees.save(new Employee("Ahmad", 1200));
        employees.save(new Employee("Omar", 1800));

        employees.printAll();

        System.out.println("\n===== Generic Method =====");

        Utils.print("Hello");
        Utils.print(100);
        Utils.print(true);

        System.out.println("\n===== Pair<K,V> =====");

        Pair<Integer, String> p1 = new Pair<>(1, "Admin");
        Pair<String, Double> p2 = new Pair<>("Salary", 2500.50);

        p1.print();
        p2.print();

        System.out.println("\n===== Wildcard =====");

        List<String> names = new ArrayList<>();

        names.add("Ali");
        names.add("Sara");
        names.add("Omar");

        Utils.printList(names);

        System.out.println("\n===== Swap =====");

        Utils.swap(names, 0, 2);

        Utils.printList(names);

        System.out.println("\n===== extends Number =====");

        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println("Sum = " + Utils.sum(numbers));

        System.out.println("\n===== super Integer =====");

        List<Number> list = new ArrayList<>();

        Utils.addIntegers(list);

        Utils.printList(list);
    }
}