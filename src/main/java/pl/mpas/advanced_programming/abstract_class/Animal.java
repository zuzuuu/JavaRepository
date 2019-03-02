package pl.mpas.advanced_programming.abstract_class;

import java.util.Objects;

public abstract class Animal {

    private static final int NAME_MIN_LENGTH = 1;
    private String name;

    public Animal(String name) {
        this.name = Objects.requireNonNull(name, "[name] cannot be null!");
        if (this.name.length() < NAME_MIN_LENGTH) {
            throw new RuntimeException(
                    "Name too short: [" + name + "], minimal length is: " + NAME_MIN_LENGTH);
        }
    }

    public abstract void eat();

    public abstract void play();



}
