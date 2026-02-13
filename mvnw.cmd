@echo off
setlocal
set MAVEN_WRAPPER_JAR=.mvn\wrapper\maven-wrapper.jar
if not exist "%MAVEN_WRAPPER_JAR%" (
  echo Maven Wrapper jar not found: %MAVEN_WRAPPER_JAR%
  exit /b 1
)

java -cp "%MAVEN_WRAPPER_JAR%" org.apache.maven.wrapper.MavenWrapperMain %*

endlocal
