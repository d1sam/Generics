package ua.od.atomspace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String str = new String("Test!");
        // никаких проблем
        Object obj = str;

        List<String> strings = new ArrayList<String>();
        // ошибка компиляции!
        // List<Object> objects = strings;

        // -----------------------------
        Animal animal1 = new Animal(1);
        Animal animal2 = new Animal(2);
        List<Animal> listOfAnimals = new LinkedList<>();
        listOfAnimals.add(animal1);
        listOfAnimals.add(animal2);
        test1(listOfAnimals);

        List<Dog> listOfDogs = new LinkedList<>();
        Dog dog1 = new Dog(1);
        Dog dog2 = new Dog(2);
        listOfAnimals.add(dog1);
        listOfAnimals.add(dog2);

        // test1(listOfDogs); // не получится так как метод принимает ИМЕННО лист анималс
        test3(listOfDogs);
    }

    public static void test1(List<Animal> animalList){
        for (Animal animal: animalList) {
            animal.eat();
        }
    }

    public static void test2(List<?> animalList){// метод принимает лист Objects
        // нельзя так как работаем с объектами как с Objects
//        for (Animal animal: animalList) {
//            animal.eat();
//        }
    }
    public static void test3(List<? extends Animal> animalList){// метод принимает всех потомков Animal и сам Animal
        for (Animal animal: animalList) {
            animal.eat();
        }
    }
    public static void test4(List<? super Dog> animalList){// метод принимает всех потомков Animal и сам Animal, но не Cat
        for (Object object : animalList) {
            if(object instanceof Animal){
                Animal animal = (Animal) object;
                animal.eat();
            }
        }
    }
}

class Animal{
    private int id;

    public Animal(int id) {
        this.id = id;
    }

    public void eat(){
        System.out.println("I'm eating..");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class Dog extends Animal{
    public Dog (int id){
        super(id);
    }
}

class Cat extends Animal{
    public Cat (int id){
        super(id);
    }
}