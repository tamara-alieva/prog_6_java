import java.util.Scanner;

public class Car extends Engine implements Participant, Cloneable {

    private static int numberOfCars = 0;

    private String brand;
    private boolean rate;
    protected Fuel fuel;

    public Car() {
        this.fuel = new Fuel();
        this.brand = "";
        this.rate = false;
        numberOfCars++;
    }

    public Car(String brand) {
        this.fuel = new Fuel();
        this.brand = brand;
        this.rate = false;
        numberOfCars++;
    }

    public Car(boolean rate) {
        this.fuel = new Fuel();
        this.brand = "";
        this.rate = rate;
        numberOfCars++;
    }

    public Car(String brand, boolean rate) {
        this.fuel = new Fuel();
        this.brand = brand;
        this.rate = rate;
        numberOfCars++;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setRate(boolean rate) {
        this.rate = rate;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    public boolean getRate() {
        return this.rate;
    }

    public static int getNumberOfCars() {
        return numberOfCars;
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        String temp; boolean flag;
        System.out.println("** Ввод данных автомобиля **");
        do {
            System.out.print("Введите марку: ");
            this.brand = scanner.nextLine();
            flag = Checking.nameCheck(this.brand);
            if (!flag) System.out.print("Попробуйте ещё раз. ");
        } while (!flag);
        do {
            System.out.print("Введите класс автомобиля (0 - Эконом, 1 - Комфорт): ");
            temp = scanner.nextLine();
            flag = Checking.booleanCheck(temp);
            if (!flag) System.out.print("Попробуйте ещё раз. ");
        } while (!flag);
        if (temp.equals("1"))
            this.rate = true;
        else
            this.rate = false;
        System.out.println("Данные успешно введены!\n");
    }

    @Override
    public String toString() {
        if (this.brand.equals("")) {
            throw new IllegalArgumentException("Отсутствует марка Автомобиля!");
        }
        else {
            String buffer = "Данные об автомобиле:\n-Марка: " + this.brand + "\n-Класс: ";
            if (this.rate) {
                buffer += "Комфорт\n";
            } else {
                buffer += "Эконом\n";
            }
            return buffer;
        }
    }

    @Override
    public Car clone() throws CloneNotSupportedException {
        Car newCar = (Car) super.clone();
        newCar.fuel = (Fuel) fuel.clone();
        return newCar;
    }
}
