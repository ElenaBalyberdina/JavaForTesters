package Lesson_4;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private final HashMap<String, Map<Integer, String>> book;

    public PhoneBook() {
        this.book = new HashMap<>();
    }

    public void add(String lastName, int phoneNumber, String eMail) {

        if (book.containsKey(lastName)) {
            book.get(lastName).put(phoneNumber, eMail);
        } else {
            Map<Integer, String> map = new HashMap<>();
            map.put(phoneNumber, eMail);
            book.put(lastName, map);
        }
    }


    public String get(String lastName) {
        String s = "";
        for (Map.Entry<String, Map<Integer, String>> pair :
                book.entrySet()) {
            if (lastName.equals(pair.getKey())) {
                s = pair.getKey() + " : " + pair.getValue();
            }
        }

        return s;
    }

}