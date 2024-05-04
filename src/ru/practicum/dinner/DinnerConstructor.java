package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;

public class DinnerConstructor {
    String type;
    String name;
    HashMap<String, ArrayList<String>> dinnerMenu = new HashMap<>();
    ArrayList<String> dishList = new ArrayList<>();

    void saveDish (String typeOfDish, String nameOfDish) {
        type = typeOfDish;
        name = nameOfDish;
        if (!dinnerMenu.containsKey(type)) {
             dishList = new ArrayList<>();
             dinnerMenu.put(type, dishList);
        }
        dishList = dinnerMenu.get(type);
        dishList.add(name);
        dinnerMenu.put(type, dishList);
    }

}
