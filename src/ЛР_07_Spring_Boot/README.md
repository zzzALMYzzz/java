# ЛР 3 — REST, валидация и журналирование

ФИО студента, номер группы.

Сборка: `./build.ps1`. Запуск: `./run.ps1`, порт 8082. Java 17+ (настроен JBR 21).

POST /feedback: uid, operationUid, systemTime, communicationId обязательны. systemName: ERP/CRM/WMS. uid=123 — пример неподдерживаемого кода.
Два упорядоченных сервиса меняют operationUid и systemTime ответа. Время UTC. INFO отражает изменения, ERROR — исключения. Codes/ErrorCodes/ErrorMessages сериализуются в значения; details содержит подробности проверки.

ЛР 1: /hello, /update-array?s=, /show-array, /update-map?s=, /show-map, /show-all-lenght.

## ЛР 4
Сначала запустите `../spring-boot-service2/run.ps1` (8084), затем этот сервис (8082). После проверки request изменяются systemName=ERP и source="Service 1". ERP сохраняет тип enum из ЛР 3. Время измеряется между приемом двух серверов через заголовок X-Request-Received-At, а не от клиентского нажатия Send. Ошибка второго сервиса дает HTTP 502. Для отдельного запуска первого сервиса: `--forwarding.enabled=false`.

## ЛР 5
Блок расчета position/salary/bonus/workDays необязателен и передается целиком. calculationYear задает год, иначе текущий. Формула годовой премии из задания: salary × bonus × daysInYear × coefficient / workDays. Квартальная: та же формула с числом календарных дней квартала (quarter=1–4), только manager=true; workDays в этом случае должен помещаться в квартал. Для PO/TPM/CTO коэффициенты в методичке не заданы: приняты 2.8/3.0/3.5 как учебное допущение. DEV=2.2, HR=1.2, TL=2.6.

## ЛР 6
H2 сохраняется в testdb/students.mv.db относительно каталога проекта. build/run запускайте из проекта (run.ps1 сам выбирает каталог). Таблицы students и disciplines создаются JPA; данные сохраняются при перезапуске. REST /api/students и /api/disciplines: GET список и /id, POST, PUT /id (или PUT с id в теле), DELETE /id. Ответ success/message/data; отсутствующий id — 404, неверные поля — 400. Для дисциплин выбраны поля name и hours. Тесты изолированы в H2 в памяти.

## ЛР 7
Откройте http://localhost:8082/ . Thymeleaf: /list (студенты), /groups (группы); создание, редактирование, удаление формами POST. Ошибки ввода отображаются возле полей. CSS локальный, интернет для страниц не нужен. Actuator: /actuator/health, /info, /metrics, /mappings, /beans (все с префиксом /actuator).
