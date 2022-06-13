package Lesson_3;

abstract class Fruit {
    private final float weight;

    Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }
}