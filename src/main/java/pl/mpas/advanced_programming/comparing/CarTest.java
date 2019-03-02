package pl.mpas.advanced_programming.comparing;

import pl.mpas.advanced_programming.comparing.Car;
import pl.mpas.advanced_programming.ref_method.CompareByColour;
import pl.mpas.advanced_programming.ref_method.CompareByModel;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarTest {

    public static void main(String[] args) {

        Car car1 = new Car("Ford", "Fiesta", "blue", Year.of(2015), 2.4);
        Car car2 = new Car("Ford",  "Fiesta", "red", Year.of(2017), 2.1);
        Car car3 = new Car("Kia", "Ceed", "pink", Year.of(2014), 1.7);
        Car car5 = new Car("Kia", "Bee", "pink", Year.of(2014), 1.7);
        Car car4 = new Car("BMW", "X5", "pink", Year.of(2019), 3.9);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        System.out.println("Before: " + cars);

        Collections.sort(cars);
        System.out.println("Natural order (automatically sorted by year): " + cars);

//        Collections.sort(cars, (o1, o2) -> o1.getYearOfProduction().compareTo(o2.getYearOfProduction()));
//        System.out.println("Collections.sort (by year): " + cars);

//        Collections.sort(cars, Comparator.comparing(Car::getCapacity));


        Car carToCompare = new Car("Ford", "Focus", "blue", Year.of(2014), 2.0);
        carToCompare.maybeComparing((Car o) -> 1);

        //metoda1 - po stworzeniu naszej klasy comparator (i.e. takiej, która implementuje Comparator<T>)
        System.out.println("After sorting by brand: ");
        Collections.sort(cars, new CarBrandComparator());
        System.out.println(cars);


        //metoda2 - z palca, z klasą anonimową
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return 0;
            }
        });
        cars.sort((o1, o2) -> o1.getBrand().compareTo(o2.getBrand()));

        CompareByModel anotherModelComparingWay = new CompareByModel();

        cars.sort((carTemp1, carTemp2) -> {
            return anotherModelComparingWay.orderByModel(carTemp1, carTemp2);
        });

        cars.sort((carTemp1, carTemp2) -> anotherModelComparingWay.orderByModel(car1, car2));   // ALT + ENTER
        cars.sort(anotherModelComparingWay::orderByModel);

        CompareByColour anotherModelComparingWay2 = new CompareByColour();
        cars.sort(anotherModelComparingWay2::orderByColour);

        System.out.println("Sorting by colour: " + cars);




    }


}
