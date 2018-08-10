/*
3.b
Подкласс Яблоко
 */
import java.util.ArrayList;

public class Box<T extends Fruit> {
    private float boxWeight; //масса нетто в коробке
    private ArrayList<T> fruits; //3.c - для хранения фруктов внутри коробки

    //конструктор коробки - формирует ArrayList из массива фруктов (с помощью метода из 2-го задания)
    public Box(T[] pack) {
        fruits = Homework1.toArrayList(pack);
    }
    // вариант конструктора для пустой коробки:
    public Box(){
        fruits = new ArrayList<T>();
    }

    //геттер содержимого коробки
    public ArrayList<T> getFruits() {
        return fruits;
    }

    //метод добавления от одного до n фруктов в коробку
    public void addFruit(T fruit) {
        fruits.add(fruit);
    }
    //вариант метода добавления упаковки фруктов (массива)
    public void addFruit(T[] pack) {
        //добавляю в ArrayList циклом FOREACH:
        for(T fruit: pack) {
            fruits.add(fruit);
        }
    }
    //неудачный метод добавления нескольких фруктов, т.к. объект всё равно один и тот же
//    public void addFruit(T fruit, int quantity) {
//        if (quantity == 1) {
//            fruits.add(fruit);
//        } else if (quantity > 1) {
//            for (int i = 0; i < quantity; i++) {
//                fruits.add(fruit);
//            }
//        }
//    }


    //3.d - получение массы нетто фруктов в коробке
    public float getBoxWeight() {
        if (fruits.size() == 0) {
            boxWeight = 0;
        } else {
            boxWeight = fruits.size() * fruits.get(0).getFruitWeigth();
        }
        return boxWeight;
    }

    //3.e - метод сравнения масс коробок compare
    public boolean compare(Box<? extends Fruit> otherBox){
        return getBoxWeight() == otherBox.getBoxWeight();
    }

    //3.f - метод пересыпки фруктов из коробки в коробку:
    public void fruitsBoxToBox (Box<T> boxIn){
        for(T fruit: fruits) {
            boxIn.addFruit(fruit); //заполняю другой ящик (коллекцию)
        }
        fruits.clear();//очищаю коллекцию
    }
}
