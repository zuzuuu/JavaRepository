package pl.mpas.advanced_programming.comparing;

import pl.mpas.advanced_programming.comparing.Car;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarTest {

    public static void main(String[] args) {

        Car car1 = new Car("Ford", "Fiesta", "blue", Year.of(2015), 2.4);
        Car car2 = new Car("Ford",  "Fiesta", "red", Year.of(2017), 2.1);
        Car car3 = new Car("Kia", "Ceed", "gray", Year.of(2014), 1.7);
        Car car4 = new Car("BMW", "X5", "pink", Year.of(2019), 3.9);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        System.out.println("Before: " + cars);

        Collections.sort(cars);
        System.out.println("Natural order (automatically sorted by year): " + cars);

//        Collections.sort(cars, (o1, o2) -> o1.getYearOfProduction().compareTo(o2.getYearOfProduction()));
//        System.out.println("Collections.sort (by year): " + cars);

    }

}
