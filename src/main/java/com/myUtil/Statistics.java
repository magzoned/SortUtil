package com.myUtil;
import java.util.List;

public class Statistics {
    private final boolean shortStats;
    private final boolean fullStats;

    public Statistics(boolean shortStats, boolean fullStats) {
        this.shortStats = shortStats;
        this.fullStats = fullStats;
    }
    // метод для подсчета статистики целых чисел
    private void printLongStats(List<Long> longs){
        if (longs == null || longs.isEmpty()) {
            return;
        }
        System.out.println("Целые числа:");
        System.out.println("  Количество: " + longs.size());
        if (fullStats) {
            long minLong = longs.get(0);
            long maxlong  = longs.get(0);
            long sum = 0;
            for (long longNum: longs)
            {
                if (longNum < minLong) {
                    minLong = longNum;
                }
                if (longNum > maxlong){
                    maxlong = longNum;
                }
                sum += longNum;
            }

            System.out.println("  Минимум: " + minLong);
            System.out.println("  Максимум: " + maxlong);
            System.out.println("  Сумма: " + sum);
            System.out.println("  Среднее: " + ((double) sum / longs.size()));
        }
    }
    // метод для подсчета статистики вещественных чисел
    private void printDoubleStats(List<Double> doubles) {
        if (doubles == null || doubles.isEmpty()) {
            return;
        }
        System.out.println("Вещественные числа:");
        System.out.println("  Количество: " + doubles.size());
        if (fullStats){
            double minDouble = doubles.get(0);
            double maxDouble  = doubles.get(0);
            double sum = 0;
            for (double doubleNum : doubles){
                if (doubleNum < minDouble){
                    minDouble = doubleNum;
                }
                if (doubleNum > maxDouble){
                    maxDouble = doubleNum;
                }
                sum += doubleNum;
            }
            System.out.println("  Минимум: " + minDouble);
            System.out.println("  Максимум: " + maxDouble);
            System.out.println("  Сумма: " + sum);
            System.out.println("  Среднее: " + (sum / doubles.size()));
        }
    }
    // метод для подсчета статистики строковых чисел
    private void printStringStats(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return;
        }
        System.out.println("Строки:");
        System.out.println("  Количество: " + strings.size());
        if (fullStats) {
            long minLen = Long.MAX_VALUE;
            long maxLen = 0;
            for (String string : strings) {
                if (string.length() < minLen){
                    minLen = string.length();
                }
                if (string.length() > maxLen) {
                    maxLen = string.length();
                }
            }
            System.out.println("  Длина самой короткой: " + minLen);
            System.out.println("  Длина самой длинной: " + maxLen);
        }
    }
    // метод для вывода собранных статистикик по данным
    public void printStats(List<Long> longs, List<Double> doubles, List<String> strings) {
        if (!shortStats && !fullStats){
            return;
        }
        System.out.println("Статистика по входным данным!");
        printLongStats(longs);
        printDoubleStats(doubles);
        printStringStats(strings);
    }
}
