package pl.mpas.advanced_programming.ref_method;

import pl.mpas.advanced_programming.comparing.Car;

public class CompareByModel {

    public int orderByModel (Car car1, Car car2) {
        return car1.getModel().compareTo(car2.getModel());
    }
}
