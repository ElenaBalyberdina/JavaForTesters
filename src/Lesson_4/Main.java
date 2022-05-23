package Lesson_4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static int countRepeat(List<String> list, String str) {
        int count = 0;
        for (String s : list) {
            if (str.equals(s)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {


        ArrayList<String> list = new ArrayList<>();
        list.add("Яблоко");
        list.add("Груша");
        list.add("Виноград");
        list.add("Яблоко");
        list.add("Апельсин");
        list.add("Грейпфрут");
        list.add("Яблоко");
        list.add("Грейпфрут");
        list.add("Манго");
        list.add("Груша");
        list.add("Виноград");
        list.add("Персик");
        list.add("Нектарин");
        list.add("Персик");
        list.add("Яблоко");
        list.add("Манго");
        list.add("Виноград");
        list.add("Яблоко");
        list.add("Лимон");
        list.add("Банан");


        Set<String> set = new HashSet<>(list);
        System.out.println(set);


        for (String s :
                set) {
            System.out.println(s + " - " + countRepeat(list, s));
        }


        PhoneBook phonebook = new PhoneBook();

        phonebook.add("Ivanov", 123456, "ivanov@mail.ru");
        phonebook.add("Ivanov", 56489, "ivanov_A@mail.ru");
        phonebook.add("Petrov", 234567, "petrov@mail.ru");
        phonebook.add("Ivanov", 345678, "ivanov_AB@mail.ru");
        phonebook.add("Sidorov", 456789, "sidorov@mail.ru");
        phonebook.add("Ivanov", 987456, "ivanov_BA@mail.ru");
        phonebook.add("Sidorov", 4888888, "sidorov_A@mail.ru");
        phonebook.add("Ivanov", 123456, "ivanov@mail.ru"); // второй раз не добавится


        System.out.println(phonebook.get("Sidorov"));
        System.out.println(phonebook.get("Ivanov"));

    }

}
