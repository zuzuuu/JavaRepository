package pl.mpas.advanced_programming.null_handling;

import java.util.Optional;
import java.util.concurrent.Callable;

public class Example {

    public static void main(String[] args) {

        Computer fullComp = new Computer(new GraphicsCard(new Chipset("nVidia")));
        Computer withoutVendor = new Computer(new GraphicsCard(new Chipset(null)));
        Computer withoutChipset = new Computer(new GraphicsCard(null));
        Computer withoutGraphicsCard = new Computer(null);
        Computer maybeComputer = null;

        Example example = new Example();
        System.out.println(example.getVendorNameSuperNaiveImpl(fullComp));



        Optional<String> maybeMyName = Optional.ofNullable(null);
        if (maybeMyName.isPresent() == true) {
            maybeMyName.get();
        } else System.out.println("Empty");

        Optional<String> maybeMyName2 = Optional.ofNullable(null);
        maybeMyName2.ifPresent(a -> System.out.println(a)); //to samo co wyżej, krócej

        maybeMyName2.ifPresent(System.out::println);    //to samo, jeszcze krócej


    }

    public String getVendorNameSuperNaiveImpl(Computer comp) {
        return comp.getGraphicsCard().getChipset().getVendorName();
    }

    public String getVendorNameSafeImpl(Computer comp) {
        String result = "Unknown";

        if (comp != null) {
            GraphicsCard maybeCard = comp.getGraphicsCard();
            if (maybeCard != null) {
                Chipset maybeChipset = maybeCard.getChipset();
                if (maybeChipset != null) {
                    String maybeVendorName = maybeChipset.getVendorName();
                    if (maybeVendorName != null) {
                        return maybeVendorName;
                    }
                }
            }
        }

        return result;
    }

    public static Optional<String> getVendorNameJava8Way(Computer comp) {
            //ofNullable - utworzenie obiektu typu Optional (nie da się konstruktorem, trzeba tak)
        return Optional.ofNullable(comp)
                .map(computer -> computer.getGraphicsCard())
                .map(graphicsCard -> graphicsCard.getChipset())
                .map(chipset -> chipset.getVendorName());
    }

    public static Optional<String> getVendorNameJava8WayShorter(Computer comp) {
        return Optional.ofNullable(comp)
                .map(Computer::getGraphicsCard)
                .map(GraphicsCard::getChipset)
                .map(Chipset::getVendorName);
    }
}