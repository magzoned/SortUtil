Версия java: java 21.0.8 2025-07-15 LTS
Java(TM) SE Runtime Environment (build 21.0.8+12-LTS-250)
Java HotSpot(TM) 64-Bit Server VM (build 21.0.8+12-LTS-250, mixed mode, sharing)
Проект реализован на сборке maven:
Apache Maven 3.9.11 (3e54c93a704957b63ee3494413a2b544fd3d825b)
Maven home: C:\Program Files\apache-maven-3.9.11
Java version: 21.0.8, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-21
Default locale: ru_RU, platform encoding: UTF-8
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
Зависимости используемые в данном проекте:
Для работы с аргументами командой строки используется библиотека Apache Commnon CLI
Версия: 1.11.0
Ссылка: https://mvnrepository.com/artifact/commons-cli/commons-cli
Для сборки исполняемого файла используется плагин: maven-assembly-plugin
версия: 3.8.0
Сборка проекта:
Для сборки проекта необходимо перейти в корневую папку проекта и выполнить команду: mvn clean package
После успешного выполнения появится папка target, содержащая файл "util.jar".
Запуск программы осуществляеся через cmd
java -jar target/util.jar ОПЦИИ ИМЕНА_входных_файлов
Пример: java -jar target/util.jar -a -f -p sample- in1.txt in2.txt
Доступные опции:
-o (path) Задать путь для выходных файлов (по умолчанию создается папка в корне с названием results).
-p (prefix) Добавить префикс к именам выходных файлов (например:"out_").
-a Режим добавления в существующие файлы (по умолчанию — перезапись).
-s Вывод краткой статистики (только количество элементов).
-f Вывод полной статистики (кол-во, мин, макс, сумма, среднее).
Перед запуском программы убедиться, что в корневую папку проекта были добавлены тестовые  входные файлы. 
