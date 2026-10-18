# ЛР 1 Spring Boot

ФИО студента, номер группы.

Spring Boot 3.1.5, целевая Java 17, встроенный Tomcat. Сборка и запуск проверяются на JDK 21 из IntelliJ IDEA.
Откройте эту папку или pom.xml в IntelliJ IDEA как Maven-проект, выберите SDK Java 21 и конфигурацию Spring Boot Lab 1. Также можно запустить main в MyFirstTestAppSpringBootApplication.

Сборка: `./build.ps1`. Запуск: `./run.ps1`. Остановка: Ctrl+C.
Адрес: http://localhost:8080/hello.

Реализованы /hello, /update-array?s=..., /show-array, /update-map?s=..., /show-map, /show-all-lenght.
Первое добавление создаёт коллекцию и сразу записывает строку. Ключи HashMap начинаются с 1. Состояние общее для всех запросов текущего процесса; после перезапуска очищается. Доступ синхронизирован. Порядок ключей HashMap не гарантирован.

Запросы requests.http и Postman-коллекцию выполняйте последовательно после перезапуска приложения. /show-all-lenght и showAllLenght написаны по методичке.
Порт 8080 общий с MVC-лабораторной: запускайте проекты поочерёдно.

Проверено: сборка исполняемого JAR и 19 HTTP-проверок. Фактические ответы — verification-results.json; журналы — verification-build.log и verification-startup.log. Также проверен запуск конфигурации Spring Boot Lab 1 непосредственно в IntelliJ IDEA.
