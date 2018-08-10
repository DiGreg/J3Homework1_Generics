/*
3.a
Суперкласс для фруктов
 */
public class Fruit {
    private String name;
    private float fruitWeigth; //вес фрукта

    //Конструктор
    public Fruit(float fruitWeigth, String name) {
        this.fruitWeigth = fruitWeigth;
        this.name = name;
    }

    //Геттер массы фрукта
    public float getFruitWeigth() {
        return fruitWeigth;
    }

    //Геттер ниаменования фрукта
    public String getName() {
        return name;
    }
}
