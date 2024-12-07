package Homework2;

import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        CreateAnimalServiceImpl service = new CreateAnimalServiceImpl();

        // Вызов метода по-умолчанию (do-while loop)
        service.createAnimals();

        // Вызов метода (for loop)
        service.createAnimals(5);

        // Вызов метода (while loop)
        CreateAnimalService defaultService = new CreateAnimalService() {};
        defaultService.createAnimals();

        // Заполнение массива animals для поиска
        Animal[] animals = new Animal[6];
        animals[0] = new Pet("Breed1", "Sheldon", 10000.085, "Calm", LocalDate.of(2016, 2, 29));
        animals[1] = new Predator("Breed2", "Gerda", 200.076, "Aggressive", LocalDate.of(2017, 3, 15));
        animals[2] = new Pet("Breed3", "Mary", 500.0, "Calm", LocalDate.of(2016, 2, 29));
        animals[3] = new Predator("Breed3", "Gamma", 300.0, "Wild", LocalDate.of(2012, 6, 30));
        animals[4] = new Pet("Breed4", "Delta", 150.0, "Friendly", LocalDate.of(2000, 1, 1));
        animals[5] = new Predator("Breed2", "Gerda", 200.076, "Aggressive", LocalDate.of(2017, 3, 15));
        // Операции поиска
        SearchServiceImpl searchService = new SearchServiceImpl();

        // Поиск животных, родившихся в висакосный год
        String[] leapYearNames = searchService.findLeapYearNames(animals);
        System.out.println("Животные, родившиеся в висакосный год: ");
        for (String name : leapYearNames) {
            System.out.println(name);
        }

        // Поиск животных, которые старше определённого количества лет, например 5
        Animal[] olderAnimals = searchService.findOlderAnimal(animals, 5);
        System.out.println("Животные старше 5 лет: ");
        for (Animal animal : olderAnimals) {
            System.out.println(animal.getName());
        }

        // Поиск дубликатов
        searchService.findDuplicate(animals);
    }
}