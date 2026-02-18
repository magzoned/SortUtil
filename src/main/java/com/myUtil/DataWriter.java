package com.myUtil;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class DataWriter {
    private final String outputPath;
    private final String outputPrefix;
    private final boolean appendStatus;

    // конструктор,здесь мы можем указать выходной путь,префикс названию файлов, статус запись/перезапись
    public DataWriter(String outputPath, String outputPrefix, boolean appendStatus) {
        this.outputPath = (outputPath == null || outputPath.isEmpty()) ? "results" : outputPath;
        this.outputPrefix = (outputPrefix == null) ? "" : outputPrefix;
        this.appendStatus = appendStatus;
    }
    // метод для сохранения считанных и обработанных данных в итоговые файлы
    public void saveFile(String fileName, List<String> data)
    {
        if (data == null || data.isEmpty())
        {
            return;
        }

        String finalName = outputPrefix + fileName;
        Path path = Paths.get(outputPath, finalName);
        try {
            if (path.getParent() != null && Files.notExists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }

            StandardOpenOption option = appendStatus ? StandardOpenOption.APPEND : StandardOpenOption.TRUNCATE_EXISTING;
            Files.write(path, data, StandardOpenOption.CREATE, StandardOpenOption.WRITE, option);

        } catch (IOException ex) {
            System.err.println("Ошибка записи в файл " + finalName + ": " + ex.getMessage());
        }

    }

}
