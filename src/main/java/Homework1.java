/*
Java 3. Обобщения (дженерики)
ДЗ №1: Работа с дженериками и не только.

Студент: Гришин Дмитрий
 */

import java.util.ArrayList;
import java.util.Arrays; //для использования методов toString() для вывода массива в строку и fill() для заполнения массива одинаковыми объектами

public class Homework1 {
    public static void main(String[] args) {
        //1. Перемена мест элементов массива (любого ссылочного типа).
        System.out.println("1 - Перемена мест элементов массива");
        String[] strArr = {"Apple", "Orange", "Apricot", "Banana", "Nectarine"};
        Integer[] intArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(Arrays.toString(strArr));//вывод массива в строку
        replaceElements(2, 3, strArr);
        System.out.println(Arrays.toString(strArr));
        System.out.println(Arrays.toString(intArr));
        replaceElements(1, 5, intArr);
        System.out.println(Arrays.toString(intArr));

        //2. Преобразование массивов в ArrayList (списочный массив).
        System.out.println("\n2 - Преобразование массивов в ArrayList");
        ArrayList<String> alStr; //объявляю экземляр ArrayList с типом хранимых данных String
        alStr = toArrayList(strArr);
        System.out.println(alStr); //вывод коллекции
        ArrayList<Integer> alInt;
        alInt = toArrayList(intArr);
        System.out.println(alInt);

        //3. Фрукты и коробки
        System.out.println("\n3 - Фрукты и коробки");
        //Есть упаковки фруктов:
        Apple[] aplPack = new Apple[14];
        Arrays.fill(aplPack, new Apple());
        Orange[] orngPack = new Orange[10];
        Arrays.fill(orngPack, new Orange());
        //System.out.println(orngPack[1].getName() + orngPack[1].getFruitWeigth());//проверка

        Box<Apple> boxApl1 = new Box<Apple>(aplPack); //создаю 1-ю коробку под яблоки и насыпаю яблоки
        Box<Apple> boxApl2 = new Box<Apple>(); //создаю пустую коробку под яблоки

        Box<Orange> boxOrng1 = new Box<Orange>(orngPack); //создаю 1-ю коробку под апельсины и насыпаю апельсины
        Box<Orange> boxOrng2 = new Box<Orange>();//создаю пустую коробку под апельсины

        //массы нетто коробок:
        System.out.println("1-я коробка под яблоки - вес фруктов = " + boxApl1.getBoxWeight());
        System.out.println("2-я коробка под яблоки - вес фруктов = " + boxApl2.getBoxWeight());
        System.out.println("1-я коробка под апельсины - вес фруктов = " + boxOrng1.getBoxWeight());
        System.out.println("2-я коробка под апельсины - вес фруктов = " + boxOrng2.getBoxWeight());

        //сравню коробки:
        System.out.println("Равны ли массы яблок и апельсинов в 1-ых коробках? Ответ: " + boxApl1.compare(boxOrng1));
        //добавлю яблоко:
        boxApl1.addFruit(new Apple());
        System.out.println("Добавил 1 яблоко. Теперь равны ли массы яблок и апельсинов? Ответ: " + boxApl1.compare(boxOrng1));

        //добавлю 1 яблоко во 2-ю пустую коробку:
        boxApl2.addFruit(new Apple());
        System.out.println("Добавил одно яблоко в пустую 2-ю коробку");
        System.out.println("2-я коробка под яблоки - вес фруктов = " + boxApl2.getBoxWeight());
        //пересыплю яблоки в во 2-ю коробку
        boxApl1.fruitsBoxToBox(boxApl2);
        System.out.println("Пересыпал яблоки из 1-й во 2-ю");
        //проверка масс:
        System.out.println("1-я коробка под яблоки - вес фруктов = " + boxApl1.getBoxWeight());
        System.out.println("2-я коробка под яблоки - вес фруктов = " + boxApl2.getBoxWeight());

        //добавлю 2-ю упаковку из 7 апельсинов
        Orange[] orngPack2 = new Orange[7];
        Arrays.fill(orngPack2, new Orange());
        boxOrng2.addFruit(orngPack2);
        System.out.println("Добавил 7 апельсинов во 2-ю коробку под апельсины. Вес фруктов = " + boxOrng2.getBoxWeight());

    }

    //1. Метод с использованием обобщения (дженерика), меняющий местами элементы массива (любого ссылочного типа).
    public static <T> void replaceElements (int indexA, int indexB, T[] array){
        if (indexA < array.length && indexA >=0 && indexB < array.length && indexB >=0) {
            T temp = array[indexA];
            array[indexA] = array[indexB];
            array[indexB] = temp;
        } else System.out.println("Введены некорректные номера индексов элементов массива");
    }

    //2. Метод, преобразующий массив в ArrayList
    public static <T> ArrayList<T> toArrayList(T[] array){
        //объявляю списочный массив с начальной ёмкостью, равной длине массива array:
        ArrayList<T> arrayList = new ArrayList<T>(array.length);
        //заполняю arrayList циклом FOREACH:
        for(T element: array) {
            arrayList.add(element);
        }
        return arrayList;
    }
}
