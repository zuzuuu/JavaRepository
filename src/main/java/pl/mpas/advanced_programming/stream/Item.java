package pl.mpas.advanced_programming.stream;

import java.math.BigDecimal;
import java.util.List;

public class Item {

    private String name;
    private BigDecimal price;
    private List<Ingredient> ingredientList;

    public Item(String name, BigDecimal price, List<Ingredient> ingredientList) {
        this.name = name;
        this.price = price;
        this.ingredientList = ingredientList;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public String getName() {
        return name;
    }
}
