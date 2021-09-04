@echo off
echo Maven Clean install and Springboot run
mvn clean install -U -DSkipTests=true
mvn spring-boot:run