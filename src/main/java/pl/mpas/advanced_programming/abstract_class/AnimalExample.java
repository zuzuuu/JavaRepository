package pl.mpas.advanced_programming.abstract_class;

public class AnimalExample {

    public static void main(String[] args) {
        // utwórz Zoo
        Zoo myZoo = new Zoo();

        // wyślij 2 zwierzęta w postaci klasy anonimowej - OJO: to będą dwie różne klasy anonimowe
        myZoo.handleAnimal(new Animal("Azor") {
            @Override
            public void eat() {
                System.out.println("Eating...");
            }

            @Override
            public void play() {
                System.out.println("Playing...");
            }
        }
        );

        myZoo.handleAnimal(new Animal("Azor") {
            @Override
            public void eat() {
                System.out.println("Eating...");
            }

            @Override
            public void play() {
                System.out.println("Playing...");
            }
        }
        );


        Animal maybeCat;

        new Animal("Kota") {
            @Override
            public void eat() {

            }

            @Override
            public void play() {

            }

            public void miauuu() {
                System.out.println("Miauuu");
            }
        }.miauuu();

    }
}
