package pl.mpas.advanced_programming.ref_method;

import pl.mpas.advanced_programming.comparing.Car;

public class CompareByColour {

    public int orderByColour(Car car1, Car car2) {
        int result;

        result = car1.getColour().compareTo(car2.getColour());

        if (result != 0) {
            return result;
        } else {
            result = car1.getBrand().compareTo(car2.getBrand());
            if (result != 0) {
                return result;
            } else {
                result = car1.getModel().compareTo(car2.getModel());
                return result;
            }
        }
    }
}
