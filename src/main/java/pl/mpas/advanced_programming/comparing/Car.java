package pl.mpas.advanced_programming.comparing;

import java.time.Year;

public class Car implements Comparable<Car>{

    private String brand, model, colour;
    private Year yearOfProduction;
    private double capacity;


    public Car(String brand, String model, String colour, Year yearOfProduction, double capacity) {
        this.brand = brand;
        this.colour = colour;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", capacity=" + capacity +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    public Year getYearOfProduction() {
        return yearOfProduction;
    }

    public double getCapacity() {
        return capacity;
    }

    @Override
    public int compareTo(Car carTemp) {
        //year comparison

        //return this.yearOfProduction.getValue() - carTemp.yearOfProduction.getValue();    -- łopatologicznie

        return this.yearOfProduction.compareTo(carTemp.getYearOfProduction());            //-- przy użyciu metody compareTo, znajdującej się w klasie Year
    }
}
