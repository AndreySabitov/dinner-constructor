//Сергей, добрый день! Очень благодарен за прошлые и текущие ревью! Поздравляю с наступающим Днём Победы!
package ru.practicum.dinner;

import java.util.Scanner;


public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateLunchCombo();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Такой команды нет!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.saveDish(dishType, dishName);// добавьте новое блюдо
    }

    private static void generateLunchCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter)." + " Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            dc.addTypesOfDishesToLunch(nextItem);
            nextItem = scanner.nextLine();
        }

        dc.generateAndPrintCombos(numberOfCombos);// сгенерируйте комбинации блюд и выведите на экран

    }
}
