$ErrorActionPreference = 'Stop'
$workspace = Split-Path $PSScriptRoot -Parent
$env:JAVA_HOME = 'C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2024.3.2.2\jbr'
$env:CATALINA_HOME = Join-Path $workspace '.tools/apache-tomcat-11.0.26'
$war = Join-Path $PSScriptRoot 'target/spring-mvc-lab.war'
if (-not (Test-Path -LiteralPath $war)) { & "$PSScriptRoot\build.ps1" }
if (-not (Test-Path "$env:CATALINA_HOME/bin/catalina.bat")) { throw 'Tomcat 11 is missing in .tools/apache-tomcat-11.0.26' }
Copy-Item -LiteralPath $war -Destination "$env:CATALINA_HOME/webapps/spring-mvc-lab.war" -Force
& "$env:CATALINA_HOME/bin/catalina.bat" run
