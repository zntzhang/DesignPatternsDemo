package facory.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 简单工厂
 */
public class SimpleAnimalFactory {
    /**
     * 第一种方法
     * @param animalTypeEnum
     * @return
     */
    public static Animal createAnimal(AnimalTypeEnum animalTypeEnum) {
        Animal animal = null;
        switch (animalTypeEnum) {
            case Cat: animal = new Cat();
            break;
            case Dog: animal = new Dog();
            break;
            case Bird: animal = new Bird();
            break;
        }
        return animal;
    }


    /**
     * 第二种方法
     */
    private static Map<AnimalTypeEnum, Supplier<Animal>> map = new HashMap<>();
    static {
        map.put(AnimalTypeEnum.Bird,Bird::new);
        map.put(AnimalTypeEnum.Cat,Cat::new);
        map.put(AnimalTypeEnum.Dog,Dog::new);
    }

    public static Animal createAnimal2(AnimalTypeEnum animalTypeEnum) {
        return map.get(animalTypeEnum).get();
    }

    public static void main(String[] args) {
        Animal animal = SimpleAnimalFactory.createAnimal(AnimalTypeEnum.Dog);
        animal.say();

        Animal animal2 = SimpleAnimalFactory.createAnimal2(AnimalTypeEnum.Cat);
        animal2.say();
    }


}
