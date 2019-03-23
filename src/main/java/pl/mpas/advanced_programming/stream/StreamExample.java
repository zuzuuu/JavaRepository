package pl.mpas.advanced_programming.stream;

import com.sun.tools.javac.jvm.Items;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {


    public static List<String> getIngredientNames(List<Order> orders) {

        return orders.stream()
                .flatMap(order -> order.getMyItems().stream())
                .flatMap(item -> item.getIngredientList().stream())
                .map(ingredient -> ingredient.getName())
                .distinct()                                     //wywalamy powtórzenia
                .collect(Collectors.toList());
    }

    public static BigDecimal getItemPrice (List<Order> orders){

        return orders.stream()
                .flatMap(order -> order.getMyItems().stream())
                .map(item -> item.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static void main(String[] args) {

        List<Ingredient> breadIngred = Arrays.asList(
                new Ingredient("mąka"),
                new Ingredient("sól"),
                new Ingredient("drożdże")
        );

        List<Ingredient> hummusIngred = Arrays.asList(
                new Ingredient("ciecierzyca"),
                new Ingredient("tahini"),
                new Ingredient("cytryna"),
                new Ingredient("czosnek"),
                new Ingredient("oliwa"),
                new Ingredient("sól")
        );

        List<Ingredient> falafelIngred = Arrays.asList(
                new Ingredient("ciecierzyca"),
                new Ingredient("kumin"),
                new Ingredient("olej rzepakowy"),
                new Ingredient("sól")
        );

        List<Ingredient> saladIngred = Arrays.asList(
                new Ingredient("sałata"),
                new Ingredient("pomidor"),
                new Ingredient("ogórek")
        );

        List<Ingredient> stuffedOlivesIngred = Arrays.asList(
                new Ingredient("oliwki"),
                new Ingredient("papryka")
        );

        Order falafelSandwich = new Order(Arrays.asList(
                new Item("bread", BigDecimal.valueOf(0.5), breadIngred),
                new Item("hummus", BigDecimal.valueOf(0.8), hummusIngred),
                new Item("falafel", BigDecimal.valueOf(1.2), falafelIngred)
        ));

        Order falafelSalad = new Order(Arrays.asList(
                new Item("salad", BigDecimal.valueOf(0.6), saladIngred),
                new Item("stuffed olives", BigDecimal.valueOf(1.3), stuffedOlivesIngred),
                new Item("falafel", BigDecimal.valueOf(1.2), falafelIngred)
        ));

        System.out.println(getIngredientNames(Arrays.asList(falafelSalad, falafelSandwich)));
        System.out.println(getItemPrice(Arrays.asList(falafelSalad, falafelSandwich)));

//        Item bread = new Item("bread", BigDecimal.valueOf(0.5), breadIngred);
//        Item hummus = new Item("hummus", BigDecimal.valueOf(0.8), hummusIngred);
//        Item falafel = new Item("falafel", BigDecimal.valueOf(1.2), falafelIngred);
//        Item salad = new Item("salad", BigDecimal.valueOf(0.6), saladIngred);
//        Item stuffedOlives = new Item("stuffed olives", BigDecimal.valueOf(1.3), stuffedOlivesIngred);

//        List<Item> falafelInSandwich = new ArrayList<>();
//        falafelInSandwich.add(bread);
//        falafelInSandwich.add(hummus);
//        falafelInSandwich.add(falafel);

//        List<Item> falafelInSalad = new ArrayList<>();
//        falafelInSalad.add(salad);
//        falafelInSalad.add(stuffedOlives);
//        falafelInSalad.add(falafel);

    }


}