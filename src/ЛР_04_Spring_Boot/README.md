# ЛР 3 — REST, валидация и журналирование

ФИО студента, номер группы.

Сборка: `./build.ps1`. Запуск: `./run.ps1`, порт 8082. Java 17+ (настроен JBR 21).

POST /feedback: uid, operationUid, systemTime, communicationId обязательны. systemName: ERP/CRM/WMS. uid=123 — пример неподдерживаемого кода.
Два упорядоченных сервиса меняют operationUid и systemTime ответа. Время UTC. INFO отражает изменения, ERROR — исключения. Codes/ErrorCodes/ErrorMessages сериализуются в значения; details содержит подробности проверки.

ЛР 1: /hello, /update-array?s=, /show-array, /update-map?s=, /show-map, /show-all-lenght.

## ЛР 4
Сначала запустите `../spring-boot-service2/run.ps1` (8084), затем этот сервис (8082). После проверки request изменяются systemName=ERP и source="Service 1". ERP сохраняет тип enum из ЛР 3. Время измеряется между приемом двух серверов через заголовок X-Request-Received-At, а не от клиентского нажатия Send. Ошибка второго сервиса дает HTTP 502. Для отдельного запуска первого сервиса: `--forwarding.enabled=false`.
