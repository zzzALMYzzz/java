$ErrorActionPreference = 'Stop'
$jar = Join-Path $PSScriptRoot 'target/spring-boot-lab1-1.0.0.jar'
if (-not (Test-Path -LiteralPath $jar)) { & "$PSScriptRoot\build.ps1" }
Push-Location $PSScriptRoot
try { & 'C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2024.3.2.2\jbr\bin\java.exe' -jar $jar
} finally { Pop-Location }
