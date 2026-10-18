# ЛР 3 — REST, валидация и журналирование

ФИО студента, номер группы.

Сборка: `./build.ps1`. Запуск: `./run.ps1`, порт 8082. Java 17+ (настроен JBR 21).

POST /feedback: uid, operationUid, systemTime, communicationId обязательны. systemName: ERP/CRM/WMS. uid=123 — пример неподдерживаемого кода.
Два упорядоченных сервиса меняют operationUid и systemTime ответа. Время UTC. INFO отражает изменения, ERROR — исключения. Codes/ErrorCodes/ErrorMessages сериализуются в значения; details содержит подробности проверки.

ЛР 1: /hello, /update-array?s=, /show-array, /update-map?s=, /show-map, /show-all-lenght.
