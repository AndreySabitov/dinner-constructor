package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> lunchMenu = new HashMap<>();
    ArrayList<String> dishList = new ArrayList<>();
    ArrayList<String> itemsOfLunch = new ArrayList<>();
    Random random = new Random();

    void saveDish(String typeOfDish, String nameOfDish) {
        ArrayList<String> dishList = lunchMenu.computeIfAbsent(typeOfDish, k -> new ArrayList<>());
        dishList.add(nameOfDish);
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

    void generateAndPrintCombos(int combos) {
        ArrayList<String> lunchCombo = new ArrayList<>();
        for (int i = 0; i < combos; i++) {
            for (String item : itemsOfLunch) {
                dishList = lunchMenu.get(item);
                lunchCombo.add(dishList.get(random.nextInt(0, dishList.size())));
            }
            System.out.println(lunchCombo);
            lunchCombo.clear();
        }
        itemsOfLunch.clear();
    }
}
