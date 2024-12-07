package Homework2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Создание интерфейса с обязательными методами
interface Animal {
    String getBreed();
    String getName();
    Double getCost();
    String getCharacter();
    LocalDate getBirthDate();
}

// Создание класса с абстрактными полями
abstract class AbstractAnimal implements Animal {
    protected String breed; // Порода
    protected String name; // Имя
    protected Double cost; // Цена
    protected String character; // Характер
    protected LocalDate birthDate; // Дата рождения

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbstractAnimal that = (AbstractAnimal) obj;
        return breed.equals(that.breed) && name.equals(that.name) &&
                cost.equals(that.cost) && character.equals(that.character) &&
                birthDate.equals(that.birthDate);
    }
}

// Создание класса Predator
class Predator extends AbstractAnimal {
    public Predator(String breed, String name, Double cost, String character, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }
    public String getBreed() { return breed; }
    public String getName() { return name; }
    public Double getCost() { return cost; }
    public String getCharacter() { return character; }
    public LocalDate getBirthDate() { return birthDate; }
}

//  Создание класса Pet
class Pet extends AbstractAnimal {
    public Pet(String breed, String name, Double cost, String character, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }
    public String getBreed() { return breed; }
    public String getName() { return name; }
    public Double getCost() { return cost; }
    public String getCharacter() { return character; }
    public LocalDate getBirthDate() { return birthDate; }
}

// Создание интерфейса CreateAnimalService
interface CreateAnimalService {
    default List<Animal> createAnimals() {
        List<Animal> animals = new ArrayList<>();
        int count = 0;
        while (count < 10) {
            animals.add(new Pet("Breed" + count, "Name" + count, 100.0 + count, "Friendly", LocalDate.now()));
            System.out.println("Животное создано: " + "Name" + count);
            count++;
        }
        return animals;
    }
}

// Наследование с перегруженными и переопределенными методами 
class CreateAnimalServiceImpl implements CreateAnimalService {
    public List<Animal> createAnimals(int N) {
        List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            animals.add(new Predator("Breed" + i, "Name" + i, 200.0 + i, "Aggressive", LocalDate.now()));
            System.out.println("Животное создано: " + "Name" + i);
        }
        return animals;
    }

    @Override
    public List<Animal> createAnimals() {
        List<Animal> animals = new ArrayList<>();
        int count = 0;
        do {
            animals.add(new Pet("Breed" + count, "Name" + count, 150.0 + count, "Calm", LocalDate.now()));
            System.out.println("Животное создано: " + "Name" + count);
            count++;
        } while (count < 10);
        return animals;
    }
}

// Создание интерфейса SearchService
interface SearchService {
    String[] findLeapYearNames(Animal[] animals);
    Animal[] findOlderAnimal(Animal[] animals, int N);
    void findDuplicate(Animal[] animals);
}

// Наследование  от интерфейса SearchService
class SearchServiceImpl implements SearchService {
    public String[] findLeapYearNames(Animal[] animals) {
        List<String> names = new ArrayList<>();
        for (Animal animal : animals) {
            int year = animal.getBirthDate().getYear();
            if (java.time.Year.isLeap(year)) {
                names.add(animal.getName());
            }
        }
        return names.toArray(new String[0]);
    }

    public Animal[] findOlderAnimal(Animal[] animals, int N) {
        List<Animal> olderAnimals = new ArrayList<>();
        LocalDate now = LocalDate.now();
        for (Animal animal : animals) {
            if (now.minusYears(N).isAfter(animal.getBirthDate())) {
                olderAnimals.add(animal);
            }
        }
        return olderAnimals.toArray(new Animal[0]);
    }

    public void findDuplicate(Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            for (int j = i + 1; j < animals.length; j++) {
                if (animals[i].equals(animals[j])) {
                    System.out.println("Найден дубликат: " + animals[i].getName());
                }
            }
        }
    }
}