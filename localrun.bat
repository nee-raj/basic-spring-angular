set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_60
set MAVEN_HOME="C:\Users\developer.brainbox\Downloads\apache-maven-3.3.3\bin"
set PATH=%PATH%;%MAVEN_HOME%;.
--mvn clean install
mvn tomcat7:run
pause