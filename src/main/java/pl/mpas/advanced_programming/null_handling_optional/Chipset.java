package pl.mpas.advanced_programming.null_handling_optional;

import java.util.Optional;

public class Chipset {

    public String vendorName;

    public Chipset(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorName() {
        return vendorName;
    }

    @Override
    public String toString() {
        return "Chipset{" +
                "vendorName='" + vendorName + '\'' +
                '}';
    }
}
