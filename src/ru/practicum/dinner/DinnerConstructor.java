package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    String typeOfDish;
    String nameOfDish;
    HashMap<String, ArrayList<String>> lunchMenu = new HashMap<>();
    ArrayList<String> dishList = new ArrayList<>();
    ArrayList<String> itemsOfLunch = new ArrayList<>();

    void saveDish(String type, String name) {
        typeOfDish = type;
        nameOfDish = name;
        if (!lunchMenu.containsKey(typeOfDish)) {
            dishList = new ArrayList<>();
        } else {
            dishList = lunchMenu.get(typeOfDish);
        }
        dishList.add(nameOfDish);
        lunchMenu.put(typeOfDish, dishList);
    }

    void addTypesOfDishesToLunch(String item) {
        if (lunchMenu.containsKey(item)) {
            itemsOfLunch.add(item);
        } else {
            System.out.println("Такого типа блюд нет в меню. Выберите другой тип из предложенных:");
            for (String type : lunchMenu.keySet()) {
                System.out.println(type);
            }
        }
    }

    void generateAndPrintCombos(int Combos, Random rand) {
        ArrayList<String> lunchCombo = new ArrayList<>();
        for (int i = 0; i < Combos; i++) {
            for (String item : itemsOfLunch) {
                dishList = lunchMenu.get(item);
                lunchCombo.add(dishList.get(rand.nextInt(0, dishList.size())));
            }
            System.out.println(lunchCombo);
            lunchCombo.clear();
        }
        itemsOfLunch.clear();
    }
}
