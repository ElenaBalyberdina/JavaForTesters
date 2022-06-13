package Lesson_3;

/**
 * 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
 * 2. Задача:
 * Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
 * Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * Для хранения фруктов внутри коробки можно использовать ArrayList;
 * Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
 * Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
 * Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
 * Не забываем про метод добавления фрукта в коробку.
 */
public class Main {

    private static <T> T[] swapElements(int firstIndex, int secondIndex, T[] array) {
        T elem;
        elem = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = elem;

        return array;
    }

    private static <T> void printArray(T[] array) {
        for (T t : array) {
            System.out.print(t + ",");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        String[] arrayOfString = new String[]{"one", "two", "three", "four", "five"};
        printArray(swapElements(0, 3, arrayOfString));

        Integer[] arrayOfInteger = new Integer[]{1, 2, 3, 4, 5};
        printArray(swapElements(1, 2, arrayOfInteger));


        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        Box<Apple> box1 = new Box<>();
        box1.add(apple1);
        box1.add(apple2);
        box1.add(apple3);
        box1.add(apple4);

        Box<Orange> box2 = new Box<>();
        box2.add(orange1);
        box2.add(orange2);
        box2.add(orange3);
        Box<Orange> box3 = new Box<>();

        box1.info();
        box2.info();
        box3.info();


        float box1Weight = box1.getWeight();
        float box2Weight = box2.getWeight();
        float box3Weight = box3.getWeight();

        System.out.println("Вес коробки 1: " + box1Weight);
        System.out.println("Вес коробки 2: " + box2Weight);
        System.out.println("Вес коробки 3: " + box3Weight);
        System.out.println("Вес коробок равен? Ответ: " + box1.compare(box2) + "\n");


        box2.transfer(box3);
        box1.info();
        box2.info();
        box3.info();

    }


}
