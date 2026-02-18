package com.myUtil;
import org.apache.commons.cli.*;
import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class SortUtil {
    public static void main(String[] args) {
        // создаем опции для cmd, как того требует ТЗ
        Options options = new Options();
        options.addOption("o", true, "Путь для результатов!");
        options.addOption("p", true,"Префикс имен выходных файлов!");
        options.addOption("a", false, "Переключение режима добавления в файлы (по умолчанию перезапись)!");
        options.addOption("s",false, "Краткая статистика");
        options.addOption("f", false, "Полная статистика");

        CommandLineParser parser = new DefaultParser();

        try {
            // обрабатываем все описанные выше опции
            CommandLine cmd = parser.parse(options, args);

            String outputPath = cmd.getOptionValue("o", "results");
            String outputPrefix = cmd.getOptionValue("p", "");
            boolean appendStatus = cmd.hasOption("a");
            boolean shortStats = cmd.hasOption("s");
            boolean fullStats = cmd.hasOption("f");

            // создаем список для названий входных файлов
            List<String> inputFiles = cmd.getArgList();
            if (inputFiles.isEmpty()) {
                System.out.println("Вы не передали файлы на вход!");
                return;
            }
            // обрабатываем файлы и распределяем по типу данных
            FileProcess fp = new FileProcess();
            for (String inputFile : inputFiles) {
                fp.processFile(inputFile);
            }
            // запись обработанных данных в конечные файлы
            DataWriter writer = new DataWriter(outputPath, outputPrefix, appendStatus);
            writer.saveFile("integers.txt", fp.getLongsAsString());
            writer.saveFile("floats.txt", fp.getDoublesAsString());
            writer.saveFile("strings.txt", fp.getStrings());

            // получаем статистику по нашим данным в зависимости от флага
            Statistics statsService = new Statistics(shortStats, fullStats);
            statsService.printStats(fp.getLongs(), fp.getDoubles(), fp.getStrings());
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
