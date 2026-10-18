$ErrorActionPreference = 'Stop'
$jar = Join-Path $PSScriptRoot 'target/spring-boot-service2-1.0.0.jar'
if (-not (Test-Path -LiteralPath $jar)) { & "$PSScriptRoot\build.ps1" }
& 'C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2024.3.2.2\jbr\bin\java.exe' -jar $jar
