package Lesson_5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class AppData {
    private String[] headers;
    private int[][] data;

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < headers.length; i++) {
            if (i < headers.length - 1) {
                builder.append(headers[i]).append(";");
            } else builder.append(headers[i]).append("\n");
        }

        for (int[] datas : data) {
            for (int j = 0; j < datas.length; j++) {
                if (j < datas.length - 1) {
                    builder.append(datas[j]).append(";");
                } else {
                    builder.append(datas[j]).append("\n");
                }
            }

        }
        return String.valueOf(builder);
    }

    /**
     * method for writing to file
     */
    public void save(File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * method for reading from file
     */
    public void load(File file) {
        String str;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            setHeaders(reader.readLine().split(";"));
            List<int[]> list = new ArrayList<>();
            while ((str = reader.readLine()) != null) {
                list.add(stringsToInt(str.split(";")));
            }
            setData(list.toArray(new int[list.size()][]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private int[] stringsToInt(String[] strings) {
        int[] ints = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        return ints;
    }
}