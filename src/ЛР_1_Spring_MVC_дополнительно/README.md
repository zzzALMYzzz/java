# ЛР 1 Чистый Spring MVC

ФИО студента, номер группы.

Spring Framework 7.0.9, Java 21, WAR, внешний Tomcat 11.0.26.
Откройте эту папку или pom.xml в IntelliJ IDEA как Maven-проект. Project SDK — Java 21 (встроенный JBR IntelliJ содержит JDK 21).

Сборка: `./build.ps1`. Запуск: `./run.ps1`. Остановка: Ctrl+C.
Tomcat находится в `../.tools/apache-tomcat-11.0.26`; запускается отдельно от приложения.
В IDEA также есть конфигурация **Tomcat 11 WAR**, которая запускает внешний Tomcat с уже развёрнутым WAR. После изменения исходников выполните build.ps1 и run.ps1 для обновления WAR.
Адрес: http://localhost:8080/spring-mvc-lab/hello.

Реализованы /hello, /about, /time и все четыре варианта /square, /length, /uppercase, /repeat. Вариант для отчёта выбирается по номеру в списке modulo 4; номер не указан, поэтому все варианты сохранены.
Повторение ограничено 100 000 кодовых единиц, отрицательный count возвращает 400.

Запросы: requests.http или импорт postman_collection.json в Postman. Проверяйте успешные ответы 200, отсутствующие обязательные параметры 400 и /unknown 404.
Порт 8080 общий с другой лабораторной: запускайте проекты поочерёдно.

Проверено: сборка WAR и 20 HTTP-проверок на внешнем Tomcat. Фактические ответы — verification-results.json; журналы — verification-build.log и verification-startup.log.
Запуск Tomcat 11 WAR также проверен непосредственно в IntelliJ IDEA: /spring-mvc-lab/hello возвращает HTTP 200 и Hello, World!.
