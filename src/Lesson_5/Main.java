package Lesson_5;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        //2. Реализовать загрузку данных из csv файла.
        AppData appData = new AppData();
        appData.load(new File("data.csv"));

        //1. Реализовать сохранение данных в csv файл;
        appData.save(new File("newData.csv"));
    }


}
