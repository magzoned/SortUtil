package com.myUtil;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class FileProcess {
    private List<Long> longs = null;
    private List<Double> doubles = null;
    private List<String> strings = null;

    public List<Long> getLongs() { return longs; }
    public List<Double> getDoubles() { return doubles; }
    public List<String> getStrings() { return strings; }

    // метод для получения списка целых чисел в виде string
    public List<String> getLongsAsString() {
        if (longs == null)
        {
            return null;
        }
        List<String> result = new ArrayList<>();
        for (Long lon : longs) result.add(lon.toString());
        return result;
    }
    // метод для получения списка вещественных чисел в виде string
    public List<String> getDoublesAsString() {
        if (doubles == null)
        {
            return null;
        }
        List<String> result = new ArrayList<>();
        for (Double doub : doubles) result.add(doub.toString());
        return result;
    }
    // Обработка входных данных
    public void processFile(String fileName){
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            System.err.println("Файл не найден: " + fileName);
            return;
        }
        // считываем по строчно данные из входного файла
        try (BufferedReader bf = Files.newBufferedReader(path))
        {
            String line;
            while ((line = bf.readLine()) != null){
                if (line.trim().isEmpty()){
                    continue;
                }
                determineLine(line);
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    // в данном методе определеяем тип данных текущей строки во входном файле(доработать)
    public void determineLine(String line){
        String trimmed = line.trim();
        if (trimmed.matches("[-+]?\\d+")) {
            if (longs == null) {
                longs = new ArrayList<>();
            }
            longs.add(Long.parseLong(trimmed));
            return;
        }
        if (trimmed.matches("-?\\d+\\.\\d+")) {
            if (doubles == null) {
                doubles = new ArrayList<>();
            }
            doubles.add(Double.parseDouble(trimmed));
            return;
        }

        if (strings == null) {
            strings = new ArrayList<>();
        }
        strings.add(line);
    }


}
