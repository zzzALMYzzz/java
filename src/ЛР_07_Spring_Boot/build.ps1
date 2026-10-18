$ErrorActionPreference = 'Stop'
$env:JAVA_HOME = 'C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2024.3.2.2\jbr'
$maven = 'C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2024.3.2.2\plugins\maven\lib\maven3\bin\mvn.cmd'
Push-Location $PSScriptRoot
try {
    & $maven '-Dmaven.repo.local=C:/Users/FAQ/Desktop/Учеба/3 семестр/прога/.tools/m2' clean package
    if ($LASTEXITCODE -ne 0) { throw 'Maven build failed' }
} finally { Pop-Location }
