import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ТЕСТЫ:");
        System.out.println("1) Перегруженный метод setInfo(...) в классе Passenger (с вызовом метода класса Person)");
        Passenger passenger1 = new Passenger();
        passenger1.setInfo("Ivan", 5000, false);
        passenger1.output();

        //System.out.println();
        System.out.println("2) Перегруженный метод setInfo(...) в классе Driver (без вызова метода класса Person)");
        Driver driver1 = new Driver();
        driver1.setInfo("Leonid", 8700, 14, 390);
        driver1.output();

    }
}