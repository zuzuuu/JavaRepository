package pl.mpas.advanced_programming.null_handling_optional;

import java.util.Optional;

public class Example {

    public static void main(String[] args) {

        Computer fullComp = new Computer(new GraphicsCard(new Chipset("nVidia")));
        Computer withoutVendor = new Computer(new GraphicsCard(new Chipset(null)));
        Computer withoutChipset = new Computer(new GraphicsCard(null));
        Computer withoutGraphicsCard = new Computer(null);
        Computer maybeComputer = null;

        System.out.println(getVendorNameJava8Way(fullComp));
        System.out.println(getVendorNameJava8Way(withoutVendor));
        System.out.println(getVendorNameJava8Way(withoutChipset));


    }

    public static String getVendorNameJava8Way(Computer comp) {

        return Optional.ofNullable(comp)
                .flatMap(computer -> comp.getGraphicsCard())
                .flatMap(graphicsCard -> graphicsCard.getChipset())
                .map(chipset -> chipset.getVendorName())
                .orElseGet(() -> "Empty");
    }

}