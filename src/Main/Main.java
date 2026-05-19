package Main;

import java.util.Arrays;
import java.util.Comparator;
import typesPackage.*;

/**
 * The entry point of the application.
 * Demonstrates creation, sorting, and searching operations on an array of SportsEquipment.
 */
public class Main {

    /**
     * Main method that initializes data, performs multi-criteria sorting,
     * and executes a linear search for a target sports equipment item.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Initialize an array of sports equipment with varied text formatting
        SportsEquipment[] equipmentArray = {
                new SportsEquipment("Футбольний\t\tм'яч", "Футбол", 1200.00, 420, 5),
                new SportsEquipment("Баскетбольний   м'яч", "Баскетбол", 1500.00, 620, 4),
                new SportsEquipment("Гантель 10кг", "Фітнес", 850.00, 10000, 5),
                new SportsEquipment("Волейбольний м'яч", "Волейбол", 950.00, 420, 3),
                new SportsEquipment("Ракетка   для\tтенісу", "Теніс", 3200.00, 280, 5),
                new SportsEquipment("М'яч для регбі", "Регбі", 1400.00, 420, 4)
        };

        System.out.println("--- Початковий масив об'єктів: ---");
        printArray(equipmentArray);

        // Sort: primary key - weight (ascending), secondary key - rating (descending)
        Arrays.sort(equipmentArray, Comparator
                .comparingInt(SportsEquipment::getWeightGrams)
                .thenComparing(Comparator.comparingInt(SportsEquipment::getRating).reversed())
        );

        System.out.println("\n--- Відсортований масив (вага верх, рейтинг низ): ---");
        printArray(equipmentArray);

        // Define a target object to search for in the array
        SportsEquipment target = new SportsEquipment("Волейбольний м'яч", "Волейбол", 950.00, 420, 3);
        System.out.println("\nОб'єкт для пошуку: " + target);

        // Linear search implementation using the overridden equals method
        int foundIndex = -1;
        for (int i = 0; i < equipmentArray.length; i++) {
            if (equipmentArray[i].equals(target)) {
                foundIndex = i;
                break;
            }
        }

        // Output search results
        if (foundIndex != -1) {
            System.out.println("Результат: Об'єкт знадено в масиві за індексом " + foundIndex);
        } else {
            System.out.println("Результат: Об'єкт не знайдено в масиві.");
        }
    }

    /**
     * Helper method to print all elements of a SportsEquipment array to the console.
     *
     * @param array the array of SportsEquipment to be printed
     */
    private static void printArray(SportsEquipment[] array) {
        for (SportsEquipment item : array) {
            System.out.println(item);
        }
    }
}